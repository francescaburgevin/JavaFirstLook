package com.example.diybyu.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/project/")
@CrossOrigin(origins = "http://localhost:4200")
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
        return projectService.getProjectById(id);
    }

    //add new resources, take request and map
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/")
    public void registerNewProject(@RequestBody Project project){
        System.out.println("register a new project in project controller");
        projectService.addNewProject(project);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path="/{id}")
    public void deleteProject(@PathVariable("id") Long id){
        projectService.deleteProject(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{id}")
    public void updateProject(
            @PathVariable("id") Long id,
            @RequestBody Project project
    ){
        projectService.updateProject(project.getId(), project.getDateAdded(), project.getName(),
                project.getTimeNeeded(), project.getMaterial(), project.getDescription(),
                project.getImageFileCode());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("keyword/{keyword}")
    public List<Project> searchByKeyword(
            @PathVariable("keyword") String keyword)
    {
        return projectService.findByKeyword(keyword);
    }

}
