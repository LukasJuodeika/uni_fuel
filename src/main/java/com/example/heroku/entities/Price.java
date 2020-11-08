package com.example.heroku.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "stationId", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Station station;

    @NotNull
    private String dateTime;

    public Price() {
    }

    public Price(String dateTime) {
        this.dateTime = dateTime;
    }

    public Price update(Price price) {
        this.dateTime = price.dateTime;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setId(long id) {
        this.id = id;
    }
}
