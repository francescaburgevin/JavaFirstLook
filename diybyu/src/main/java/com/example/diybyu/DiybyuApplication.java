package com.example.diybyu;

import com.example.diybyu.project.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class DiybyuApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiybyuApplication.class, args);
	}

	@GetMapping("/")
	public List<Project> project(){
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
