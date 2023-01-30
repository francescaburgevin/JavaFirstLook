package com.example.diybyu.project;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    //public void findKeyword(Project project){
    //    Optional<Project> projectOptional = projectRepository.findProjectByKeyword(project.toString());
    //    if(projectOptional.isPresent()){
    //        return project;
    //    }
    //}

    public void deleteProject(Long projectId){
        boolean exists = projectRepository.existsById(projectId);
        if(!exists){
            throw new IllegalStateException("Project with id "+projectId+" does not exist.");
        }
        projectRepository.deleteById(projectId);
    }


    @Transactional
    public void updateProject(Long projectId, LocalDate date_added,
                              String name, Integer time_needed,
                              String material, String description,
                              String thumbnail){
        Project project = projectRepository.findById(projectId)
                .orElseThrow(()->new IllegalStateException(
                        "Project with id "+projectId+" does not exist."
                ));
        if(name != null && name.length()>0
                 && !Objects.equals(project.getName(), name)) {
            project.setName(name);
        }

        if(material != null && material.length()>0
                && !Objects.equals(project.getMaterial(), material)) {
            project.setMaterial(material);
        }

        if(description != null && description.length()>0
                && !Objects.equals(project.getDescription(), description)) {
            project.setDescription(description);
        }

        if(thumbnail != null && thumbnail.length()>0
                && !Objects.equals(project.getThumbnail(), thumbnail)) {
            project.setThumbnail(thumbnail);
        }

        //must finish. add date, time
    }

}
