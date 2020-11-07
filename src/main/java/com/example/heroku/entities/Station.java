package com.example.heroku.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String address;
    private String lat;
    private String lng;
    private String title;

    public Station() {
    }

    public Station(String address, String lat, String lng, String title) {
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
