package com.example.diybyu.project;

import java.awt.*;
import java.time.LocalDate;

public class Project {
    private Long id;
    private LocalDate date_added;
    private String name;
    private Integer time_needed;
    private String material;
    private String description;
    private String thumbnail;

    //empty constructor
    public Project() {
    }

    // constructor with id
    public Project(Long id, LocalDate date_added, String name, Integer time_needed,
                   String material, String description, String thumbnail) {
        this.id = id;
        this.date_added = date_added;
        this.name = name;
        this.time_needed = time_needed;
        this.material = material;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    //constructor without id
    public Project(LocalDate date_added, String name, Integer time_needed,
                   String material, String description, String thumbnail) {
        this.date_added = date_added;
        this.name = name;
        this.time_needed = time_needed;
        this.material = material;
        this.description = description;
        this.thumbnail = thumbnail;
    }


    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate_added() {
        return date_added;
    }

    public void setDate_added(LocalDate date_added) {
        this.date_added = date_added;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime_needed() {
        return time_needed;
    }

    public void setTime_needed(Integer time_needed) {
        this.time_needed = time_needed;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", date_added=" + date_added +
                ", name='" + name + '\'' +
                ", time_needed=" + time_needed +
                ", material='" + material + '\'' +
                ", description=" + description +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
