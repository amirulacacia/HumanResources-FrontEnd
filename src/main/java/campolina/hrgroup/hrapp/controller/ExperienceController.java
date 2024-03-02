package campolina.hrgroup.hrapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.Experience;
import campolina.hrgroup.hrapp.service.ExperienceService;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.createExperience(experience);
    }

    @GetMapping("/{experienceId}")
    public Experience getExperienceById(@PathVariable Long experienceId) {
        return experienceService.getExperienceById(experienceId);
    }

    @GetMapping
    public List<Experience> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    @PutMapping("/{experienceId}")
    public Experience updateExperience(@RequestBody Experience experience,
                                       @PathVariable Long experienceId) {
        return experienceService.updateExperience(experience);
    }

    @DeleteMapping("/{experienceId}")
    public String deleteExperience(@PathVariable Long experienceId) {
        return experienceService.deleteExperience(experienceId);
    }
}

