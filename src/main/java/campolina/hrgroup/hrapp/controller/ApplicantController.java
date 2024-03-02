package campolina.hrgroup.hrapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.Applicant;
import campolina.hrgroup.hrapp.service.ApplicantService;

@RestController
@RequestMapping("/applicants") 
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

