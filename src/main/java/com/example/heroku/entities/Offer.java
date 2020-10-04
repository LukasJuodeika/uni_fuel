package com.example.heroku.entities;

public class Offer {
    private long id;
    private String title;
    private String description;

    public Offer() {
    }

    public Offer(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
