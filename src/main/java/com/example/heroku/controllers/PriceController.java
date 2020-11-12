package com.example.heroku.controllers;

import com.example.heroku.entities.Price;
import com.example.heroku.entities.Station;
import com.example.heroku.repositories.PricesRepository;
import com.example.heroku.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.example.heroku.common.Constants.ROLE_ADMIN;
import static com.example.heroku.common.Constants.ROLE_USER;

@RestController
@RequestMapping("/api")
public class PriceController {

    @Autowired
    private PricesRepository pricesRepository;

    @Autowired
    private StationsRepository stationsRepository;

    @Secured({ROLE_ADMIN})
    @PostMapping("/station/{id}/price")
    public Price createPrice(@Valid @RequestBody Price price, @PathVariable long id) {
        Optional<Station> station = stationsRepository.findById(id);
        if (station.isPresent()) {
            price.setStation(station.get());
            return pricesRepository.save(price);
        }
        throw new IllegalArgumentException("No station with id: " + id);
    }

    @Secured({ROLE_ADMIN, ROLE_USER})
    @GetMapping("/station/{id}/price")
    public List<Price> readPriceList(@PathVariable long id) {
        return pricesRepository.findByStationId(id);
    }

    @Secured({ROLE_ADMIN, ROLE_USER})
    @GetMapping("/price/{priceId}")
    public Price readPrice(@PathVariable long priceId) {
        return pricesRepository.findById(priceId).get();
    }

    @Secured({ROLE_ADMIN})
    @PutMapping("/price/{priceId}")
    public Price updatePrice(@Valid @RequestBody Price price, @PathVariable long priceId) {
        Price dbPrice = pricesRepository.findById(priceId).get();
        return pricesRepository.save(dbPrice.update(price));
    }

    @Secured({ROLE_ADMIN})
    @DeleteMapping("/price/{priceId}")
    public void deletePrice(@PathVariable long priceId) {
        pricesRepository.deleteById(priceId);
    }

    @Secured({ROLE_ADMIN})
    @DeleteMapping("/station/{stationId}/price")
    public void deleteAllPricesForStation(@PathVariable long stationId) {
        pricesRepository.deleteByStationId(stationId);
    }
}
