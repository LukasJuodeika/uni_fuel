package com.example.heroku.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;

    protected Offer() {
    }

    public Offer(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Offer[id=%d, title=%s, description=%s", id, title, description);
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
