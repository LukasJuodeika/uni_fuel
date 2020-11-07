package com.example.heroku.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long stationId;
    private String dateTime;

    public Price() {
    }

    public Price(long stationId, String dateTime) {
        this.stationId = stationId;
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public long getStationId() {
        return stationId;
    }
}
