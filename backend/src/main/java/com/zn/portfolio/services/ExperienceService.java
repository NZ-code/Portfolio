package com.zn.portfolio.services;

import com.zn.portfolio.entities.Experience;


import com.zn.portfolio.repositories.ExperienceRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class ExperienceService {

    private ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository){
        this.experienceRepository = experienceRepository;
    }
    public List<Experience> getExperiences() {
        return experienceRepository.findAll();
    }

    public Experience getExperience(String id) {
        return experienceRepository.findById(Integer.valueOf(id))
                .orElseThrow(() ->  new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "this experience not found"
                ));
    }

    public void createExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    public void deleteExperience(String id) {
        experienceRepository.deleteById(Integer.valueOf(id));
    }
    //ToDo fix update
    public void updateExperience(String id, Experience experience) {
        experience.setId(Long.valueOf(id));
        experienceRepository.save(experience);
    }
}
