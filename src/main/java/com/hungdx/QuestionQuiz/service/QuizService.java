package com.hungdx.QuestionQuiz.service;

import com.hungdx.QuestionQuiz.model.Question;
import com.hungdx.QuestionQuiz.model.Quiz;
import com.hungdx.QuestionQuiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    QuizRepository repo;
    QuestionService service;

    @Autowired
    public QuizService(QuizRepository repo, QuestionService service) {
        this.repo = repo;
        this.service = service;
    }

    public Quiz createQuiz( String title, String tag, int numQuestion) {
        List<Question> list = service.createQuestionByTag(numQuestion, tag);
        Quiz quiz = new Quiz(title, list);
        return repo.save(quiz);
    }

    public List<Quiz> getAllQuiz() {
        return repo.findAll();
    }

    public Quiz getQuizById(int id) {
        return repo.findById(id).get();
    }

}
