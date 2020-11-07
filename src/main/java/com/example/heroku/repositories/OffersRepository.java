package com.example.heroku.repositories;

import com.example.heroku.entities.Offer;
import org.springframework.data.repository.CrudRepository;

public interface OffersRepository extends CrudRepository<Offer, Long> {
}
