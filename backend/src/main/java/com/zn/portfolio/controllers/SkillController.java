package com.zn.portfolio.controllers;


import com.zn.portfolio.entities.Skill;
import com.zn.portfolio.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.zn.portfolio.utils.Constants.*;

@RestController
@CrossOrigin(origins = "*")
public class SkillController {

    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }

    @GetMapping(API_SKILLS_URI)
    public List<Skill> getSkills(){
        return skillService.getSkills();
    }

    @GetMapping(API_SPECIFIC_SKILL_URI)
    public Skill getSkill(@PathVariable(name=SKILL_ID_PATH_VAR) String id){
        return skillService.getSkill(id);
    }
    @PostMapping(API_SKILLS_URI)
    public void saveSkill(@RequestBody Skill skill){
        skillService.createSkill(skill);
    }
    @DeleteMapping(API_SPECIFIC_SKILL_URI)
    public void deleteSkill(@PathVariable(name = SKILL_ID_PATH_VAR) String id){
        skillService.deleteSkill(id);
    }
    @PutMapping(API_SPECIFIC_SKILL_URI)
    public void updateSkill(@PathVariable(name = SKILL_ID_PATH_VAR) String id,
                              @RequestBody Skill skill){
        skillService.updateProject(id, skill);
    }
    //--------------------------------------------------------------------------------///
    @GetMapping(API_SPECIFIC_PROJECT_SKILLS_URI)
    public List<Skill> getSkillsFromProject(@PathVariable(name = PROJECT_ID_PATH_VAR) String projectId){
        return skillService.getSkillsByProjectId(projectId);
    }
    @PostMapping(API_SPECIFIC_PROJECT_SKILLS_URI)
    public void postSkillToProject(@PathVariable(name = PROJECT_ID_PATH_VAR) String projectId,
                                          @RequestBody Skill skill){
        skillService.postSkillByProjectId(skill, projectId);
    }
    @PutMapping(API_SPECIFIC_PROJECT_SPECIFIC_SKILL_URI)
    public void putSkillToProject(@PathVariable(name = PROJECT_ID_PATH_VAR) String projectId,
                                  @PathVariable(name = SKILL_ID_PATH_VAR) String skillId,
                                   @RequestBody Skill skill){
        skillService.putSkillByProjectId(skill, projectId, skillId);
    }
    @DeleteMapping(API_SPECIFIC_PROJECT_SPECIFIC_SKILL_URI)
    public void deleteSkillFromProject(@PathVariable(name = PROJECT_ID_PATH_VAR) String projectId,
                                       @PathVariable(name = SKILL_ID_PATH_VAR) String skillId
                                   ){
        skillService.deleteSkillFromProject(projectId, skillId);
    }
}
