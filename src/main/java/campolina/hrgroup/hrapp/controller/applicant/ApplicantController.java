package campolina.hrgroup.hrapp.controller.applicant;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import campolina.hrgroup.hrapp.model.applicant.Applicant;
import campolina.hrgroup.hrapp.service.applicant.ApplicantService;

@RestController
@RequestMapping("/applicant") 
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> findAllApplicants() {
        return applicantService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteApplicant(@PathVariable Long id) {
        return applicantService.deleteApplicant(id);
    }

    @PutMapping("/{id}")
    public Applicant updateApplicant(@RequestBody Applicant applicant, @PathVariable Long id) {
        return applicantService.updateApplicant(applicant, id);
    }

    @GetMapping("/{id}")
    public Applicant getApplicantById(@PathVariable Long id) {
        return applicantService.findById(id);
    }

    @PostMapping
    public Applicant saveApplicant(@RequestBody Applicant applicant) {
        return applicantService.save(applicant);
    }
}

