package com.example.heroku.controllers;

import com.example.heroku.entities.Offer;
import com.example.heroku.entities.Station;
import com.example.heroku.repositories.OffersRepository;
import com.example.heroku.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OfferController {

    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private StationsRepository stationsRepository;

    @PostMapping("/station/{id}/offer")
    public Offer createOffer(@Valid @RequestBody Offer offer, @PathVariable long id) {
        Optional<Station> station = stationsRepository.findById(id);
        if (station.isPresent()) {
            offer.setStation(station.get());
            return offersRepository.save(offer);
        }
        throw new IllegalArgumentException("No station with id: " + id);
    }

    @GetMapping("/station/{id}/offer")
    public List<Offer> readOfferList(@PathVariable long id) {
        return offersRepository.findByStationId(id);
    }

    @GetMapping("/offer/{offerId}")
    public Offer readOffer(@PathVariable long offerId) {
        return offersRepository.findById(offerId).get();
    }

    @PutMapping("/offer/{offerId}")
    public Offer updateOffer(@Valid @RequestBody Offer offer, @PathVariable long offerId) {
        Offer dbOffer = offersRepository.findById(offerId).get();
        return offersRepository.save(dbOffer.update(offer));
    }

    @DeleteMapping("/offer/{offerId}")
    public void deleteOffer(@PathVariable long offerId) {
        offersRepository.deleteById(offerId);
    }

    @DeleteMapping("/station/{stationId}/offer")
    public void deleteAllOffersForStation(@PathVariable long stationId) {
        offersRepository.deleteByStationId(stationId);
    }
}
