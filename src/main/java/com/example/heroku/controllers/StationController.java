package com.example.heroku.controllers;

import com.example.heroku.entities.Station;
import com.example.heroku.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StationController {

    @Autowired
    StationsRepository stationsRepository;

    @PostMapping("/station")
    public Station createStation(@RequestBody Station station) {
        return stationsRepository.save(station);
    }

    @GetMapping("/station/{id}")
    public Station readStation(@PathVariable long id) {
        return new Station("Savanoriai", "54.898521", "23.903597", "Station 1");
    }

    @GetMapping("/station")
    public List<Station> readStationList() {
        List<Station> list = new ArrayList<>();
        stationsRepository.findAll().forEach(list::add);
        return list;
    }

    @PutMapping("/station/{id}")
    public Station updateStation(@RequestBody Station station, @PathVariable long id) {
        return station;
    }

    @DeleteMapping("/station/{id}")
    public Station deleteStation(@PathVariable long id) {
        return new Station("Savanoriai", "54.898521", "23.903597", "Station 1");
    }

}
