import { useState } from "react";

// If localhost acts weird on macOS sockets, try 127.0.0.1
const API_BASE = "http://127.0.0.1:8080/api/quiz";

export default function Quiz() {
  const [stage, setStage] = useState("start"); // start | playing | result
  const [questions, setQuestions] = useState([]);
  const [idx, setIdx] = useState(0);
  const [answers, setAnswers] = useState({}); // questionId -> optionId
  const [score, setScore] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);

  const startQuiz = async () => {
    setLoading(true);
    setError(null);
    try {
      const res = await fetch(`${API_BASE}?size=10`);
      if (!res.ok) {
        const txt = await res.text();
        throw new Error(txt || `Request failed: ${res.status}`);
      }
      const data = await res.json();
      if (!Array.isArray(data) || data.length === 0) {
        throw new Error("No questions returned from server.");
      }
      setQuestions(data);
      setIdx(0);
      setAnswers({});
      setScore(null);
      setStage("playing");
    } catch (e) {
      console.error(e);
      setError(e.message);
      setStage("start");
    } finally {
      setLoading(false);
    }
  };

  const selectOption = (qId, oId) => {
    setAnswers((prev) => ({ ...prev, [qId]: oId }));
  };

  const next = () => {
    if (idx < questions.length - 1) setIdx((i) => i + 1);
    else submit();
  };

  const submit = async () => {
    try {
      const payload = {
        answers: Object.entries(answers).map(([qId, oId]) => ({
          questionId: Number(qId),
          optionId: Number(oId),
        })),
      };
      const res = await fetch(`${API_BASE}/submit`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
      });
      if (!res.ok) {
        const txt = await res.text();
        throw new Error(txt || `Submit failed: ${res.status}`);
      }
      const data = await res.json();
      setScore(data.score ?? 0);
      setStage("result");
    } catch (e) {
      console.error(e);
      setError(e.message);
      setStage("start");
    }
  };

  const restart = () => {
    setStage("start");
    setQuestions([]);
    setIdx(0);
    setAnswers({});
    setScore(null);
    setError(null);
  };

  if (stage === "start") {
    return (
        <div className="card">
          <p>You will get 10 random questions. +1 for each correct answer.</p>
          {error && <p style={{ color: "crimson" }}>{error}</p>}
          <button className="btn" onClick={startQuiz} disabled={loading}>
            {loading ? "Loading…" : "Start Quiz"}
          </button>
        </div>
    );
  }

  if (stage === "playing") {
    // Safety guards
    if (!Array.isArray(questions) || questions.length === 0) {
      return (
          <div className="card">
            <p>No questions loaded.</p>
            <button className="btn" onClick={startQuiz}>Try again</button>
          </div>
      );
    }
    const q = questions[idx];
    if (!q) {
      return (
          <div className="card">
            <p>Loading question…</p>
          </div>
      );
    }

    const selected = answers[q.id];
    const progress = `${idx + 1} / ${questions.length}`;

    return (
        <div className="card">
          <div className="progress">{progress}</div>
          <h2 className="question">{q.text}</h2>
          <div className="options">
            {q.options?.map((opt) => (
                <label
                    key={opt.id}
                    className={`option ${selected === opt.id ? "selected" : ""}`}
                >
                  <input
                      type="radio"
                      name={`q-${q.id}`}
                      checked={selected === opt.id}
                      onChange={() => selectOption(q.id, opt.id)}
                  />
                  {opt.text}
                </label>
            ))}
          </div>
          <button className="btn" onClick={next} disabled={selected == null}>
            {idx === questions.length - 1 ? "Submit" : "Next"}
          </button>
        </div>
    );
  }

  // result
  return (
      <div className="card center">
        <h2>Your Score</h2>
        <div className="score">{score} / 10</div>
        <button className="btn" onClick={restart}>Restart</button>
        <button className="btn outline" onClick={startQuiz}>Try Again (New 10)</button>
      </div>
  );
}
