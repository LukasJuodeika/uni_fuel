package com.example.heroku.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String address;

    @NotBlank
    private String lat;

    @NotBlank(message = "Must not be empty")
    private String lng;

    @NotBlank
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
