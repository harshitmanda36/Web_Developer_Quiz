package com.example.quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "option_choice")
public class OptionChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // change "text" below if your column is named differently (e.g., option_text)
    @Column(name = "text", nullable = false, length = 300)
    private String text;

    // use the exact boolean column name you created (we expect 'correct' TINYINT(1)/BIT)
    @Column(name = "correct", nullable = false)
    private boolean correct;

    // FK column MUST be named exactly as below or change the name value to match
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public OptionChoice() {}
    public OptionChoice(Long id, String text, boolean correct, Question question) {
        this.id = id; this.text = text; this.correct = correct; this.question = question;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public boolean isCorrect() { return correct; }
    public void setCorrect(boolean correct) { this.correct = correct; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
}
