package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.ApplicantStatus;
import campolina.hrgroup.hrapp.repository.ApplicantStatusRepository;
import campolina.hrgroup.hrapp.service.ApplicantStatusService;

@Service
public class ApplicantStatusServiceImplementation implements ApplicantStatusService {

    @Autowired
    private ApplicantStatusRepository applicantStatusRepository;

    @Override
    public ApplicantStatus createApplicantStatus(ApplicantStatus applicantStatus) {
        return applicantStatusRepository.save(applicantStatus);
    }

    @Override
    public ApplicantStatus getApplicantStatusById(Long applicantStatusId) {
        return applicantStatusRepository.findById(applicantStatusId).orElse(null);
    }

    @Override
    public List<ApplicantStatus> getAllApplicantStatuses() {
        return applicantStatusRepository.findAll();
    }

    @Override
    public ApplicantStatus updateApplicantStatus(ApplicantStatus applicantStatus) {
        return applicantStatusRepository.save(applicantStatus);
    }

    @Override
    public String deleteApplicantStatus(Long applicantStatusId) {
        applicantStatusRepository.deleteById(applicantStatusId);
        return "Applicant status with ID: " + applicantStatusId + " has been deleted successfully";
    }
}

