package com.example.diybyu.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

//interface responsible for data access

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.name LIKE CONCAT('%',:keyword,'%')")
    List<Project> findProjectByKeyword(@Param("keyword") String keyword);

}
