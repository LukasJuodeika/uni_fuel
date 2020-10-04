package com.example.heroku.controllers;

import com.example.heroku.entities.Station;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StationController {

    @PostMapping("/station")
    public Station createStation(@RequestBody Station station) {
        return station;
    }

    @GetMapping("/station/{id}")
    public Station readStation(@PathVariable long id) {
        return new Station(id, "Savanoriai", "54.898521", "23.903597", "Station 1");
    }

    @GetMapping("/station")
    public List<Station> readStationList() {
        Station station = new Station(1L, "Savanoriai", "54.898521", "23.903597", "Station 1");
        Station station2 = new Station(2L, "Savanoriai", "54.898521", "23.903597", "Station 1");
        List<Station> stationList = new ArrayList<>();
        stationList.add(station);
        stationList.add(station2);
        return stationList;
    }

    @PutMapping("/station/{id}")
    public Station updateStation(@RequestBody Station station, @PathVariable long id) {
        return station;
    }

    @DeleteMapping("/station/{id}")
    public Station deleteStation(@PathVariable long id) {
        return new Station(1L, "Savanoriai", "54.898521", "23.903597", "Station 1");
    }

}
