package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.ApplicantStatus;
import campolina.hrgroup.hrapp.repository.ApplicantStatusRepository;
import campolina.hrgroup.hrapp.service.ApplicantStatusService;

@Service
@Transactional
public class ApplicantStatusServiceImplementation implements ApplicantStatusService {

    @Autowired
    private ApplicantStatusRepository applicantStatusRepository;

    @Override
    public ApplicantStatus getApplicantStatusById(Long applicantStatusId) {
        return applicantStatusRepository.findById(applicantStatusId).orElse(null);
    }

    @Override
    public List<ApplicantStatus> getAllApplicantStatuses() {
        return applicantStatusRepository.findAll();
    }

    @Override
    public ApplicantStatus updateApplicantStatus(ApplicantStatus applicantStatus, Long id) {
        ApplicantStatus applicantStatusDB = applicantStatusRepository.findById(id).get();

        if (Objects.nonNull(applicantStatus.getStatus())) {
            applicantStatusDB.setStatus(applicantStatus.getStatus());
        }

        return applicantStatusRepository.save(applicantStatusDB);
    }
}

