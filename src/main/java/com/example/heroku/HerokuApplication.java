package com.example.heroku;

import com.example.heroku.repositories.OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class HerokuApplication {

    @Autowired
    OffersRepository offersRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HerokuApplication.class, args);
    }

    @RequestMapping("/")
    String index() {
        return "index";
    }
}
