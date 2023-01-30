package com.example.diybyu.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.time.*;

@Configuration
public class ProjectConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            ProjectRepository repository){
        return args -> {
            Project knitScarf = new Project(
                    LocalDate.now(),
                    "Knit an easy scarf",
                    360,
                    "Knitting needles size 6 and 5 balls of yarn",
            "A beginner knitting project where repetition is key.",
            "./main/resources/images/knit_scarf.jpg"
            );

            Project oriBateau = new Project(
                    LocalDate.now(),
                    "Perfect paper boat",
                    5,
                    "One square piece of paper.",
                    "Kids of all ages will love to build this boat.",
                    "./main/resources/images/origami_boat.jpg"
            );

            repository.saveAll(
                    List.of(knitScarf, oriBateau)
            );

        };
    }
}
