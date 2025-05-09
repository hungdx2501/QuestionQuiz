package com.hungdx.QuestionQuiz.controller;

import com.hungdx.QuestionQuiz.model.Quiz;
import com.hungdx.QuestionQuiz.model.QuizMapping;
import com.hungdx.QuestionQuiz.repository.QuizRepository;
import com.hungdx.QuestionQuiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    private QuizService service;

    @Autowired
    public QuizController(QuizService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizMapping quizMapping) {
        Quiz quiz = service.createQuiz(quizMapping.getTitle(), quizMapping.getTag(), quizMapping.getNum());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quiz);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuiz() {
        List<Quiz> list = service.getAllQuiz();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable int id) {
        Quiz quiz = service.getQuizById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quiz);
    }
}
