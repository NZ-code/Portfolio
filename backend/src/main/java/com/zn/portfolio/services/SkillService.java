package com.zn.portfolio.services;

import com.zn.portfolio.entities.Project;
import com.zn.portfolio.entities.Skill;

import com.zn.portfolio.repositories.ProjectRepository;
import com.zn.portfolio.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    private SkillRepository skillRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository, ProjectRepository projectRepository){
        this.skillRepository = skillRepository;
        this.projectRepository = projectRepository;
    }
    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkill(String id) {
        return skillRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException());
    }

    public void createSkill(Skill skill) {
        skillRepository.save(skill);
    }

    public void deleteSkill(String id) {
        skillRepository.deleteById(Integer.valueOf(id));
    }
    //ToDo fix update
    public void updateProject(String id, Skill skill) {
        skill.setId(Long.valueOf(id));
        skillRepository.save(skill);
    }
    //-----------------------------------------------
    public List<Skill> getSkillsByProjectId(String projectId) {
        Optional<Project> project = projectRepository.findById(Integer.valueOf(projectId));

        if(project.isPresent()){
            return skillRepository.findAllByProject(project.get());
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "project with this id not found"
        );
    }

    public void postSkillByProjectId(Skill skill, String projectId) {
        Optional<Project> project = projectRepository.findById(Integer.valueOf(projectId));

        if(project.isPresent()){
            skill.setProject(project.get());
            skillRepository.save(skill);
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "project with this id not found"
            );
        }
    }

    public void deleteSkillFromProject(String projectId, String skillId) {
        skillRepository.deleteById(Integer.valueOf(skillId));
    }

    public void putSkillByProjectId(Skill skill, String projectId, String skillId) {
        Optional<Project> project = projectRepository.findById(Integer.valueOf(projectId));

        if(project.isPresent()){
            skill.setId(Long.valueOf(skillId));

            skillRepository.save(skill);
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "project with this id not found"
            );
        }
    }
}
