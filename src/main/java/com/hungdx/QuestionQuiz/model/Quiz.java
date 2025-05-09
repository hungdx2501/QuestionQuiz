package com.hungdx.QuestionQuiz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Question> questions;

    public Quiz() {

    }

    public Quiz(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }


}
