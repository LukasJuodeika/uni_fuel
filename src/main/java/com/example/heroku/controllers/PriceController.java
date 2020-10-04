package com.example.heroku.controllers;

import com.example.heroku.entities.Price;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceController {

    @PostMapping("/station/{id}/price")
    public Price createPrice(@RequestBody Price price, @PathVariable long id) {
        return price;
    }

    @GetMapping("/station/{id}/price")
    public List<Price> readPriceList(@PathVariable long id) {
        Price price = new Price(1L, id, "2020-01-01");
        Price price2 = new Price(2L, id, "2020-01-01");
        List<Price> priceList = new ArrayList<>();
        priceList.add(price);
        priceList.add(price2);
        return priceList;
    }

    @GetMapping("/station/{id}/price/{priceId}")
    public Price readPrice(@PathVariable long id, @PathVariable long priceId) {
        return new Price(priceId, id, "2020-01-01");
    }

    @PutMapping("/station/{id}/price/{priceId}")
    public Price updatePrice(@RequestBody Price price, @PathVariable long id, @PathVariable long priceId) {
        return price;
    }

    @DeleteMapping("/station/{id}/price/{priceId}")
    public Price deletePrice(@PathVariable long id, @PathVariable long priceId) {
        return new Price(priceId, id, "2020-02-01");
    }
}
