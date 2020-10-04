package com.example.heroku.controllers;

import com.example.heroku.entities.Offer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OfferController {

    @PostMapping("/station/{id}/offer")
    public Offer createOffer(@PathVariable long id, @RequestBody Offer offer) {
        return offer;
    }

    @GetMapping("/station/{id}/offer")
    public List<Offer> readOfferList(@PathVariable long id) {
        Offer offer = new Offer(1L, "title1", "description description");
        Offer offer2 = new Offer(2L, "title2", "description description description");
        List<Offer> offers = new ArrayList<>();
        offers.add(offer);
        offers.add(offer2);
        return offers;
    }

    @GetMapping("/station/{id}/offer/{offerId}")
    public Offer readOffer(@PathVariable long id, @PathVariable long offerId) {
        return new Offer(1L, "title1", "description description");
    }

    @PutMapping("/station/{id}/offer/{offerId}")
    public Offer updateOffer(@RequestBody Offer offer, @PathVariable long id, @PathVariable long offerId) {
        return offer;
    }

    @DeleteMapping("/station/{id}/offer/{offerId}")
    public Offer deleteOffer(@PathVariable long id, @PathVariable long offerId) {
        return new Offer(offerId, "title", "description");
    }
}
