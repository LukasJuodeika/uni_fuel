package com.example.heroku.entities;

public class Price {
    private long id;
    private long stationId;
    private String dateTime;

    public Price() {
    }

    public Price(long id, long stationId, String dateTime) {
        this.id = id;
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
