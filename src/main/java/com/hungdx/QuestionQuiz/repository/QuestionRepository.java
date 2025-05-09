package com.hungdx.QuestionQuiz.repository;

import com.hungdx.QuestionQuiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByTagIgnoreCase(String tag);
}
