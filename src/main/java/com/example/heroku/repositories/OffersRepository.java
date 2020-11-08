package com.example.heroku.repositories;

import com.example.heroku.entities.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OffersRepository extends CrudRepository<Offer, Long> {

    List<Offer> findByStationId(long stationId);

    long deleteByStationId(long stationId);
}
