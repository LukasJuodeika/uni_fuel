package com.example.heroku;

import com.example.heroku.common.Constants;
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

import java.util.Set;

@SpringBootApplication
public class HerokuApplication {

    @Autowired
    OffersRepository offersRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HerokuApplication.class, args);
    }

    @Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
            service.save(new UserEntity(
                    "user",
                    "user",
                    Set.of(new Role(Constants.ROLE_USER))
            ));
            service.save(new UserEntity(
                    "admin",
                    "admin",
                    Set.of(new Role(Constants.ROLE_USER), new Role(Constants.ROLE_ADMIN))
            ));

        };
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
