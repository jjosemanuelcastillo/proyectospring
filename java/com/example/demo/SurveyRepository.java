package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SurveyRepository {
	private List<Survey> surveys = new ArrayList<>();

    public void addSurvey(Survey survey) {
        surveys.add(survey);
    }

    public List<Survey> getAllSurveys() {
        return surveys;
    }

    public Optional<Survey> getSurveyById(Long id) {
        return surveys.stream()
            .filter(s -> s.getId().equals(id))
            .findFirst();
    }
}
