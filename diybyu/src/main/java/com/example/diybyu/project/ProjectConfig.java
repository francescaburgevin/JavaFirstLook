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
            "https://pixabay.com/get/g51eb43767035c112ece2bccfeca83d1d0c4ed150ea2c6068f795432edb038ef6ba4cde9ee5782ad5d55bdce08d3656ea7f900c0f2448de5fc20f7fcced43327b039c83b079b1a42f36fe0be3c2964166_1920.jpg"
            );

            Project oriBateau = new Project(
                    LocalDate.now(),
                    "Perfect paper boat",
                    5,
                    "One square piece of paper.",
                    "Kids of all ages will love to build this boat.",
                    "https://pixabay.com/get/g6bc4b8188585e7044cbb5736988770745c1b585bdb28b5c95f11e0a46bd7f7f079f8d69448df194bf729a22d4bc0e5fdf86788d46541cb14c56cd9fb1bea8b444594612a7fd11e74de11f6a294dbffa8_1920.jpg"
            );

            repository.saveAll(
                    List.of(knitScarf, oriBateau)
            );

        };
    }
}
