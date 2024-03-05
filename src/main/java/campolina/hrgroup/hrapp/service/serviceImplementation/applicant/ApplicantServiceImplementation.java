package campolina.hrgroup.hrapp.service.serviceImplementation.applicant;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.applicant.Applicant;
import campolina.hrgroup.hrapp.repository.applicant.ApplicantRepository;
import campolina.hrgroup.hrapp.service.applicant.ApplicantService;

@Service
@Transactional
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
    public Applicant save(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public Boolean isApplicantHaveTruePassword(Map<String, String> map) {
        try {
            Applicant applicant = applicantRepository.findByEmail(map.get("email")).get();
            if (applicant.getPassword().equals(map.get("password")))
                return true;
            else
                return false;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    @Override
    public Applicant registerApplicant(Map<String, String> map) {
        Applicant applicant = new Applicant();

        if (!(map.get("email").equals(null) || map.get("password").equals(null))) {
            applicant.setEmail(map.get("email"));
            applicant.setPassword(map.get("password"));
            return applicantRepository.save(applicant);
        }else
            return null;
    }
}
