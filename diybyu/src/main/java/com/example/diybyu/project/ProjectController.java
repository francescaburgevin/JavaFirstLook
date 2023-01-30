package com.example.diybyu.project;

//all resources for the api
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    //get data
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/")
    public List<Project> getProjects(){
        return projectService.getProjects();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Object getProjectById(@PathVariable("id") Long id){
        System.out.println("getting project by id");
        return projectService.getProjectById(id);
    }



    //add new resources, take request and map
    @PostMapping
    public void registerNewProject(@RequestBody Project project){
        projectService.addNewProject(project);
    }

    @DeleteMapping(path="{id}")
    public void deleteProject(@PathVariable("id") Long id){
        projectService.deleteProject(id);
    }

    @PutMapping(path = "{id}")
    public void updateProject(
            @PathVariable("id") Long projectId,
            @RequestParam(required = false) LocalDate date_added,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer time_needed,
            @RequestParam(required = false) String material,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String thumbnail) {
                projectService.updateProject(projectId, date_added, name, time_needed, material, description, thumbnail);
            }
}
