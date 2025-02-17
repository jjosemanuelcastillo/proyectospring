package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SurveyController {

    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    @Autowired
    public SurveyController(SurveyRepository surveyRepository, QuestionRepository questionRepository, OptionRepository optionRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    @GetMapping("/surveys")
    public String listSurveys(Model model) {
        List<Survey> surveys = surveyRepository.findAll();
        model.addAttribute("surveys", surveys);
        return "survey-list";
    }

    @GetMapping("/survey/{id}")
    public String showSurvey(@PathVariable Long id, Model model) {
        Survey survey = surveyRepository.findById(id).orElseThrow();
        model.addAttribute("survey", survey);
        return "survey-detail";
    }

    @PostMapping("/submitVote/{id}")
    public String submitVote(@PathVariable Long id, @RequestParam Long voteId, Model model) {
        Optional<Survey> surveyOpt = surveyRepository.findById(id);
        if (surveyOpt.isPresent()) {
            Survey survey = surveyOpt.get();
            for (Question question : survey.getQuestions()) {
                for (Option option : question.getOptions()) {
                    if (option.getId().equals(voteId)) {
                        option.incrementVotes();
                        optionRepository.save(option); // Guardamos el cambio de votos
                    }
                }
            }
            model.addAttribute("survey", survey);
            return "resultado";
        }
        return "error";
    }
}