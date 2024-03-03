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

    @PostMapping("{user}/{userId}")
    public Experience createExperience(@RequestBody Experience experience,
    @PathVariable("user") String user, @PathVariable("userId") Long userId) {
        return experienceService.createExperience(experience, user, userId);
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
        return experienceService.updateExperience(experience, experienceId);
    }

    @DeleteMapping("/{experienceId}")
    public String deleteExperience(@PathVariable Long experienceId) {
        return experienceService.deleteExperience(experienceId);
    }
}

