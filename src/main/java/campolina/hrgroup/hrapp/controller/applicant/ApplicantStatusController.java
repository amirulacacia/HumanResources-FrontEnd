package campolina.hrgroup.hrapp.controller.applicant;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import campolina.hrgroup.hrapp.model.applicant.ApplicantStatus;
import campolina.hrgroup.hrapp.service.applicant.ApplicantStatusService;

@RestController
@RequestMapping("/applicantStatus")
public class ApplicantStatusController {

    @Autowired
    private ApplicantStatusService applicantStatusService;

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
        return applicantStatusService.updateApplicantStatus(applicantStatus, applicantStatusId);
    }
}

