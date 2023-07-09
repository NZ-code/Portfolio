package com.zn.portfolio.controllers;

import com.zn.portfolio.entities.Project;
import com.zn.portfolio.services.ProjectService;
import com.zn.portfolio.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.zn.portfolio.utils.Constants.*;

@RestController
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping(API_PROJECTS_URI)
    public List<Project> getProjects(){
        return projectService.getProjects();
    }

    @GetMapping(API_SPECIFIC_PROJECT_URI)
    public Project getProject(@PathVariable(name=PROJECT_ID_PATH_VAR) String id){
        return projectService.getProject(id);
    }
    @PostMapping(API_PROJECTS_URI)
    public void saveProject(@RequestBody Project project){
        projectService.createProject(project);
    }
    @DeleteMapping(API_SPECIFIC_PROJECT_URI)
    public void deleteProject(@PathVariable(name = PROJECT_ID_PATH_VAR) String id){
        projectService.deleteProject(id);
    }
    @PutMapping(API_SPECIFIC_PROJECT_URI)
    public void updateProject(@PathVariable(name = PROJECT_ID_PATH_VAR) String id,
                              @RequestBody Project project){

        projectService.updateProject(id, project);
    }

}
