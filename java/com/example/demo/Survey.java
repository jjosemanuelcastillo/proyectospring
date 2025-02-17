package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Survey {
	private Long id;
    private String title;
    private List<Question> questions;

    public Survey(Long id, String title) {
        this.id = id;
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
