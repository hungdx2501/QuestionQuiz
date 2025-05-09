package com.hungdx.QuestionQuiz.service;

import com.hungdx.QuestionQuiz.model.Question;
import com.hungdx.QuestionQuiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    QuestionRepository repo;

    @Autowired
    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public Question addQuestion(Question question) {
        return repo.save(question);
    }

    public List<Question> getAllQuestions() {
        return repo.findAll();
    }

    public Optional<Question> getQuestionById(int id) {
        return repo.findById(id);
    }

    public void deleteQuestionById(int id) {
        repo.deleteById(id);
    }

    public void deleteAllQuestions() {
        repo.deleteAll();
    }
}
