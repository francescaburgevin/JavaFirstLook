package com.example.diybyu.project;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public Object getProjectById(Long id){
        return projectRepository.findById(id);
    }

    //add new project
    public void addNewProject(Project project){
        projectRepository.save(project);
    }

    public List<Project> findByKeyword(String keyword){
        System.out.println("findbykeyword in project service "+keyword);
        List<Project> projectByKeyword = projectRepository.findProjectByKeyword(keyword);
        if (projectByKeyword.isEmpty()){
            throw new IllegalStateException("nothing found");
        }
        return projectByKeyword;
    }

    public void deleteProject(Long id){
        boolean exists = projectRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Project with id "+id+" does not exist.");
        }
        System.out.println("deleteProject javaService");
        projectRepository.deleteById(id);
    }


    @Transactional
    public void updateProject(
            Long id,
            LocalDate dateAdded,
            String name,
            Integer timeNeeded,
            String material,
            String description,
            String thumbnail
    ){
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Project with id "+id+" does not exist."
                ));
        if(
                name != null && name.length() > 0 &&
                !Objects.equals(project.getName(), name)
        ) {
            project.setName(name);
            project.setDateAdded(LocalDate.now());
        }

        if(
                timeNeeded != null &&
                        timeNeeded > 0 &&
                        !Objects.equals(project.getTimeNeeded(), timeNeeded)
        ) {
            project.setTimeNeeded(timeNeeded);
            project.setDateAdded(LocalDate.now());
        }

        if(
                material != null &&
                material.length() > 0 &&
                !Objects.equals(project.getMaterial(), material)
        ) {
            project.setMaterial(material);
            project.setDateAdded(LocalDate.now());
        }

        if(
                description != null &&
                description.length() > 0 &&
                !Objects.equals(project.getDescription(), description)
        ) {
            project.setDescription(description);
            project.setDateAdded(LocalDate.now());
        }

        if(
                thumbnail != null &&
                thumbnail.length() > 0 &&
                !Objects.equals(project.getThumbnail(), thumbnail)
        ) {
            project.setThumbnail(thumbnail);
            project.setDateAdded(LocalDate.now());
        }

        projectRepository.save(project);
        //must finish. add date
    }

}
