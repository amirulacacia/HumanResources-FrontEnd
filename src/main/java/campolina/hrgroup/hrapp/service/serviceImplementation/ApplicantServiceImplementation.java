package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Applicant;
import campolina.hrgroup.hrapp.repository.ApplicantRepository;
import campolina.hrgroup.hrapp.service.ApplicantService;

@Service
public class ApplicantServiceImplementation implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public List<Applicant> findAll() {
        return applicantRepository.findAll();
    }

    @Override
    public String deleteApplicant(Long id) {
        applicantRepository.deleteById(id);
        return "Applicant with ID: " + id + " has been deleted successfully";
    }

    @Override
    public Applicant updateApplicant(Applicant applicant, Long id) {
        applicant.setApplicantId(id);
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant findById(Long id) {
        return applicantRepository.findById(id).orElse(null);
    }

    @Override
    public Applicant save(Applicant applicant, Long id) {
        applicant.setApplicantId(id);
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant save(Applicant applicant) {
        return applicantRepository.save(applicant);
    }
}
