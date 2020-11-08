package com.example.heroku.repositories;

import com.example.heroku.entities.Price;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PricesRepository extends CrudRepository<Price, Long> {

    List<Price> findByStationId(long stationId);

    long deleteByStationId(long stationId);
}
