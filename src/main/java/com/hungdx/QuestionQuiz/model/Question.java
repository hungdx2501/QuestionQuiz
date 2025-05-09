package com.hungdx.QuestionQuiz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    @ElementCollection
    List<String> choices;
    String answer;
    String tag;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", choices=" + choices +
                ", answer='" + answer + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
