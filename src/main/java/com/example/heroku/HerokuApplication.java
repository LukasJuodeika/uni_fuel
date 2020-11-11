package com.example.heroku;

import com.example.heroku.entities.Role;
import com.example.heroku.entities.UserEntity;
import com.example.heroku.repositories.OffersRepository;
import com.example.heroku.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@SpringBootApplication
public class HerokuApplication {

    @Autowired
    OffersRepository offersRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HerokuApplication.class, args);
    }

    @GetMapping(value = "/")
    public String index() {
        return "Hello world";
    }

    @GetMapping(value = "/private")
    public String privateArea() {
        return "Private area";
    }

    @Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
            service.save(new UserEntity(
                    "user", //username
                    "user", //password
                    Set.of(new Role("USER"), new Role("ADMIN"))
            ));
        };
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
