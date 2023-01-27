package com.example.diybyu.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//interface responsible for data access

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

//    @Query("SELECT keyword FROM Project WHERE keyword = keyword")
//Optional<Project> findProjectByKeyword(String keyword);

}
