package com.example.heroku.controllers;

import com.example.heroku.entities.Station;
import com.example.heroku.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.example.heroku.common.Constants.ROLE_ADMIN;
import static com.example.heroku.common.Constants.ROLE_USER;

@RestController
@RequestMapping("/api")
public class StationController {

    @Autowired
    private StationsRepository stationsRepository;

    @Secured({ROLE_ADMIN})
    @PostMapping("/station")
    public Station createStation(@Valid @RequestBody Station station) {
        return stationsRepository.save(station);
    }

    @Secured({ROLE_ADMIN, ROLE_USER})
    @GetMapping("/station/{id}")
    public Station readStation(@PathVariable long id) {
        return stationsRepository.findById(id).get();
    }

    @Secured({ROLE_ADMIN, ROLE_USER})
    @GetMapping("/station")
    public List<Station> readStationList() {
        List<Station> list = new ArrayList<>();
        stationsRepository.findAll().forEach(list::add);
        return list;
    }

    @Secured({ROLE_ADMIN})
    @PutMapping("/station/{id}")
    public Station updateStation(@Valid @RequestBody Station station, @PathVariable long id) {
        Station dbStation = stationsRepository.findById(id).get();
        return stationsRepository.save(dbStation.update(station));
    }

    @Secured({ROLE_ADMIN})
    @DeleteMapping("/station/{id}")
    public void deleteStation(@PathVariable long id) {
        stationsRepository.deleteById(id);
    }

}
