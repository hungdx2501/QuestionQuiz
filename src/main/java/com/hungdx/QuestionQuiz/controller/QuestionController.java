package com.hungdx.QuestionQuiz.controller;

import com.hungdx.QuestionQuiz.model.Question;
import com.hungdx.QuestionQuiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question result = service.addQuestion(question);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> list = service.getAllQuestions();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @GetMapping("/tag/{tag}")
    public ResponseEntity<List<Question>> getAllQuestionsByTag(@PathVariable String tag) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAllQuestionsByTag(tag));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) {
        Question question = service.getQuestionById(id).get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(question);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllQuestions() {
        service.deleteAllQuestions();
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id) {
        service.deleteQuestionById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
