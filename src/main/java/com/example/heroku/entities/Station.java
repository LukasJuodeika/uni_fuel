package com.example.heroku.entities;

public class Station {
    private long id;
    private String address;
    private String lat;
    private String lng;
    private String title;

    public Station() {
    }

    public Station(long id, String address, String lat, String lng, String title) {
        this.id = id;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getTitle() {
        return title;
    }
}
