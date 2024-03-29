package com.example.diybyu.project;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Project {
    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )

    private Long id;
    private LocalDate dateAdded;
    private String name;
    private Integer timeNeeded;
    private String material;
    private String description;
    private String imageFileCode;

    //empty constructor
    public Project() {
    }

    // constructor with id
    public Project(Long id, LocalDate dateAdded, String name, Integer timeNeeded,
                   String material, String description, String imageFileCode) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.name = name;
        this.timeNeeded = timeNeeded;
        this.material = material;
        this.description = description;
        this.imageFileCode = imageFileCode;
    }

    //constructor without id
    public Project(LocalDate dateAdded, String name, Integer timeNeeded,
                   String material, String description, String imageFileCode) {
        this.dateAdded = dateAdded;
        this.name = name;
        this.timeNeeded = timeNeeded;
        this.material = material;
        this.description = description;
        this.imageFileCode = imageFileCode;
    }


    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeNeeded() {
        return timeNeeded;
    }

    public void setTimeNeeded(Integer timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageFileCode() {
        return imageFileCode;
    }

    public void setImageFileCode(String imageFileCode) {
        this.imageFileCode = imageFileCode;
    }



    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", date_added=" + dateAdded +
                ", name='" + name + '\'' +
                ", time_needed=" + timeNeeded +
                ", material='" + material + '\'' +
                ", description=" + description +
                ", imageFileCode='" + imageFileCode + '\'' +
                '}';
    }
}

