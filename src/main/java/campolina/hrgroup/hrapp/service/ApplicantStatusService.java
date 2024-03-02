package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.ApplicantStatus;

@Service
public interface ApplicantStatusService {
    
    ApplicantStatus createApplicantStatus(ApplicantStatus applicantStatus);

    ApplicantStatus getApplicantStatusById(Long applicantStatusId);

    List<ApplicantStatus> getAllApplicantStatuses();

    ApplicantStatus updateApplicantStatus(ApplicantStatus applicantStatus);

    String deleteApplicantStatus(Long applicantStatusId);
}
