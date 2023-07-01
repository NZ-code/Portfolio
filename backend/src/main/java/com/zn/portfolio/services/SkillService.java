package com.zn.portfolio.services;

import com.zn.portfolio.entities.Skill;

import com.zn.portfolio.exceptions.SkillNotFoundException;
import com.zn.portfolio.repositories.SkillRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillService {

    private SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }
    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkill(String id) {
        return skillRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new SkillNotFoundException());
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
}
