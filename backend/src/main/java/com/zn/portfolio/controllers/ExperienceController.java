package  com.zn.portfolio.controllers;

import com.zn.portfolio.entities.Experience;
import com.zn.portfolio.services.ExperienceService;
import com.zn.portfolio.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class ExperienceController {

    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService){
        this.experienceService = experienceService;
    }

    @GetMapping("/api/experiences")
    public List<Experience> getExperiences(){
        return experienceService.getExperiences();
    }

    @GetMapping("/api/experiences/{experienceId}")
    public Experience getExperience(@PathVariable(name="experienceId") String id){
        return experienceService.getExperience(id);
    }
    @PostMapping("/api/experiences")
    public void saveExperience(@RequestBody Experience experience){
        experienceService.createExperience(experience);
    }
    @DeleteMapping("/api/experiences/{experienceId}")
    public void deleteExperience(@PathVariable(name = "experienceId") String id){
        experienceService.deleteExperience(id);
    }
    @PutMapping("/api/experiences/{experienceId}")
    public void updateExperience(@PathVariable(name = "experienceId") String id,
                              @RequestBody Experience experience){

        experienceService.updateExperience(id, experience);
    }

}
