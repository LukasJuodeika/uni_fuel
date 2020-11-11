package com.example.heroku.services;


import com.example.heroku.entities.UserEntity;
import com.example.heroku.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        repo.save(userEntity);
    }

}