package com.example.heroku.repositories;


import com.example.heroku.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
