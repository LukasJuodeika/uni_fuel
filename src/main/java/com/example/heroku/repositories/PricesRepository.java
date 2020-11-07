package com.example.heroku.repositories;

import com.example.heroku.entities.Price;
import org.springframework.data.repository.CrudRepository;

public interface PricesRepository extends CrudRepository<Price, Long> {
}
