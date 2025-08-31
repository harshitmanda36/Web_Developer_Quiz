package com.example.quiz.controller;

import com.example.quiz.dto.ScoreResponseDTO;
import com.example.quiz.dto.SubmitRequestDTO;
import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // FIXED: Added parameter name explicitly
    @GetMapping
    public ResponseEntity<?> getQuiz(@RequestParam(name = "size", defaultValue = "10") int size) {
        try {
            List<QuestionDTO> questions = quizService.getRandomQuiz(size);
            return ResponseEntity.ok(questions);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/submit")
    public ScoreResponseDTO submit(@RequestBody SubmitRequestDTO req) {
        return quizService.score(req);
    }
}