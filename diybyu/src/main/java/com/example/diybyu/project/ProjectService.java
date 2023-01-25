package com.example.diybyu.project;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {

    //a static list
    public List<Project> getProjects(){
        return List.of(
                new Project(
                        1L,
                        LocalDate.now(),
                        "Knit a sweater",
                        100,
                        "yarn, knitting needles",
                        "Any easy beginner project that will allow you to practice the same stitch.",
                        "thumbnail.jpg"
                )
        );
    }

}
