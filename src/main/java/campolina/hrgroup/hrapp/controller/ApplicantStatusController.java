package campolina.hrgroup.hrapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.ApplicantStatus;
import campolina.hrgroup.hrapp.service.ApplicantStatusService;

@RestController
@RequestMapping("/applicantStatus")
public class ApplicantStatusController {

    @Autowired
    private ApplicantStatusService applicantStatusService;

    @PostMapping
    public ApplicantStatus createApplicantStatus(@RequestBody ApplicantStatus applicantStatus) {
        return applicantStatusService.createApplicantStatus(applicantStatus);
    }

    @GetMapping("/{applicantStatusId}")
    public ApplicantStatus getApplicantStatusById(@PathVariable Long applicantStatusId) {
        return applicantStatusService.getApplicantStatusById(applicantStatusId);
    }

    @GetMapping
    public List<ApplicantStatus> getAllApplicantStatuses() {
        return applicantStatusService.getAllApplicantStatuses();
    }

    @PutMapping("/{applicantStatusId}")
    public ApplicantStatus updateApplicantStatus(@RequestBody ApplicantStatus applicantStatus,
                                                 @PathVariable Long applicantStatusId) {
        return applicantStatusService.updateApplicantStatus(applicantStatus);
    }

    @DeleteMapping("/{applicantStatusId}")
    public String deleteApplicantStatus(@PathVariable Long applicantStatusId) {
        return applicantStatusService.deleteApplicantStatus(applicantStatusId);
    }
}

