package campolina.hrgroup.hrapp.controller.information;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import campolina.hrgroup.hrapp.model.information.Education;
import campolina.hrgroup.hrapp.service.information.EducationService;

@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @PostMapping("{user}/{userId}")
    public Education createEducation(@RequestBody Education education,
            @PathVariable("user") String user, @PathVariable("userId") Long userId) {
        return educationService.createEducation(education, user, userId);
    }

    @GetMapping("/{educationId}")
    public Education getEducationById(@PathVariable Long educationId) {
        return educationService.getEducationById(educationId);
    }

    @GetMapping
    public List<Education> getAllEducations() {
        return educationService.getAllEducations();
    }

    @PutMapping("/{educationId}")
    public Education updateEducation(@RequestBody Education education,
            @PathVariable Long educationId) {
        return educationService.updateEducation(education, educationId);
    }

    @DeleteMapping("/{educationId}")
    public String deleteEducation(@PathVariable Long educationId) {
        return educationService.deleteEducation(educationId);
    }
}
