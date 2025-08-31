package com.example.quiz.service;

import com.example.quiz.dto.OptionDTO;
import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.dto.ScoreResponseDTO;
import com.example.quiz.dto.SubmitAnswerDTO;
import com.example.quiz.dto.SubmitRequestDTO;
import com.example.quiz.model.OptionChoice;
import com.example.quiz.model.Question;
import com.example.quiz.repo.OptionChoiceRepository;
import com.example.quiz.repo.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    private final QuestionRepository questionRepo;
    private final OptionChoiceRepository optionRepo;

    public QuizService(QuestionRepository questionRepo, OptionChoiceRepository optionRepo) {
        this.questionRepo = questionRepo;
        this.optionRepo = optionRepo;
    }

    @Transactional(readOnly = true)
    public List<QuestionDTO> getRandomQuiz(int size) {
        List<Question> all = questionRepo.findAll(); // options preloaded via @EntityGraph
        Collections.shuffle(all);

        int limit = Math.min(size, all.size());
        List<QuestionDTO> out = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            Question q = all.get(i);
            List<OptionDTO> opts = new ArrayList<>();
            if (q.getOptions() != null) {
                for (OptionChoice o : q.getOptions()) {
                    opts.add(new OptionDTO(o.getId(), o.getText()));
                }
            }
            out.add(new QuestionDTO(q.getId(), q.getText(), opts));
        }
        return out;
    }

    @Transactional(readOnly = true)
    public ScoreResponseDTO score(SubmitRequestDTO req) {
        if (req == null || req.getAnswers() == null || req.getAnswers().isEmpty()) {
            return new ScoreResponseDTO(0, 0);
        }
        List<Long> optionIds = new ArrayList<>();
        for (SubmitAnswerDTO a : req.getAnswers()) {
            if (a != null && a.getOptionId() != null) optionIds.add(a.getOptionId());
        }

        Map<Long, Boolean> correctness = new HashMap<>();
        for (OptionChoice oc : optionRepo.findAllById(optionIds)) {
            correctness.put(oc.getId(), oc.isCorrect());
        }

        int score = 0;
        for (SubmitAnswerDTO a : req.getAnswers()) {
            Boolean ok = correctness.get(a.getOptionId());
            if (Boolean.TRUE.equals(ok)) score++;
        }
        return new ScoreResponseDTO(score, req.getAnswers().size());
    }
}
