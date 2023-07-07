package com.zn.portfolio.repositories;


import com.zn.portfolio.entities.Project;
import com.zn.portfolio.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository  extends JpaRepository<Skill, Integer> {
    List<Skill> findAllByProject(Project project);
}
