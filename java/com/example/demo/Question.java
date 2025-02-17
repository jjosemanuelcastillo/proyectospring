package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private Long id;
    private String questionText;
    private List<Option> options;

    public Question(Long id, String questionText) {
        this.id = id;
        this.questionText = questionText;
        this.options = new ArrayList<>();
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public List<Option> getOptions() {
        return options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Long getId() {
        return id;
    }
}
