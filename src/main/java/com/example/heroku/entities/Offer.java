package com.example.heroku.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "stationId", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Station station;

    protected Offer() {
    }

    public Offer(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Offer update(Offer offer) {
        this.title = offer.title;
        this.description = offer.description;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Offer[id=%d, title=%s, description=%s", id, title, description);
    }

    public void setId(long id) {
        this.id = id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
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
