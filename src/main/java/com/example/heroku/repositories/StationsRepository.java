package com.example.heroku.repositories;

import com.example.heroku.entities.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationsRepository extends CrudRepository<Station, Long> {
}
