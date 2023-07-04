package com.zn.portfolio.services;

import com.zn.portfolio.entities.Project;
import com.zn.portfolio.exceptions.ProjectNotFoundException;
import com.zn.portfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }
    public Project getProject(String id) {
        Project project = projectRepository.findById(Integer.valueOf(id)).orElseThrow(
                ()->new ProjectNotFoundException()
        );
        return project;
    }

    public void createProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(String id){
        projectRepository.deleteById(Integer.valueOf(id));
    }

    public void updateProject(String id, Project project) {
        project.setId(Long.valueOf(id));
        projectRepository.save(project);
    }
}
