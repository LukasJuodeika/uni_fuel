package com.example.heroku.controllers;

import com.example.heroku.entities.Station;
import com.example.heroku.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StationController {

    @Autowired
    private StationsRepository stationsRepository;

    @PostMapping("/station")
    public Station createStation(@Valid @RequestBody Station station) {
        return stationsRepository.save(station);
    }

    @GetMapping("/station/{id}")
    public Station readStation(@PathVariable long id) {
        return stationsRepository.findById(id).get();
    }

    @GetMapping("/station")
    public List<Station> readStationList() {
        List<Station> list = new ArrayList<>();
        stationsRepository.findAll().forEach(list::add);
        return list;
    }

    @PutMapping("/station/{id}")
    public Station updateStation(@Valid @RequestBody Station station, @PathVariable long id) {
        Station dbStation = stationsRepository.findById(id).get();
        return stationsRepository.save(dbStation.update(station));
    }

    @DeleteMapping("/station/{id}")
    public void deleteStation(@PathVariable long id) {
        stationsRepository.deleteById(id);
    }

}
