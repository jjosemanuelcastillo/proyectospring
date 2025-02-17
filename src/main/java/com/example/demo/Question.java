package com.example.demo;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    public Question() {}

    public Question(String questionText) {
        this.questionText = questionText;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void addOption(Option option) {
        options.add(option);
        option.setQuestion(this);
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}

