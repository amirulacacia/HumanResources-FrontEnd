package campolina.hrgroup.hrapp.service.applicant;

import java.util.List;
import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.applicant.ApplicantStatus;

@Service
public interface ApplicantStatusService {

    ApplicantStatus getApplicantStatusById(Long applicantStatusId);

    List<ApplicantStatus> getAllApplicantStatuses();

    ApplicantStatus updateApplicantStatus(ApplicantStatus applicantStatus, Long id);
}
