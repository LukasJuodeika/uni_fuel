package com.example.heroku.controllers;

import com.example.heroku.entities.Role;
import com.example.heroku.entities.UserEntity;
import com.example.heroku.repositories.UsersRepository;
import com.example.heroku.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

import static com.example.heroku.common.Constants.ROLE_USER;

@RestController
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public void createStation(@Valid @RequestBody RegisterRequest registerRequest) {
        if (usersRepository.findByUsername(registerRequest.getUsername()).isPresent())
            throw new IllegalArgumentException("Username is taken");

        usersRepository.save(
                new UserEntity(
                        registerRequest.getUsername(),
                        passwordEncoder.encode(registerRequest.getPassword()),
                        Set.of(new Role(ROLE_USER))
                )
        );
    }

}
