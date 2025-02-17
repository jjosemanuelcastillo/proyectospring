package com.example.demo;

public class Option {
	private Long id;
    private String optionText;
    private int votes;

    public Option(Long id, String optionText) {
        this.id = id;
        this.optionText = optionText;
        this.votes = 0;
    }

    public void incrementVotes() {
        this.votes++;
    }

    public String getOptionText() {
        return optionText;
    }

    public int getVotes() {
        return votes;
    }

    public Long getId() {
        return id;
    }
}
