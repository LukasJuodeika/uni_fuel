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

    @NotBlank
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

    public Station update(Station station) {
        this.address = station.address;
        this.lat = station.lat;
        this.lng = station.lng;
        this.title = station.title;
        return this;
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
