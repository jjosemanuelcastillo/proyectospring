package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "optionn") // Cambia el nombre de la tabla
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String optionText;
    private int votes;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Option() {}

    public Option(String optionText) {
        this.optionText = optionText;
        this.votes = 0;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getOptionText() {
        return optionText;
    }

    public int getVotes() {
        return votes;
    }

    public void incrementVotes() {
        this.votes++;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
