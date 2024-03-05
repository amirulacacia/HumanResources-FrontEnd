package campolina.hrgroup.hrapp.service.applicant;

import java.util.List;
import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.applicant.Applicant;

@Service
public interface ApplicantService {
   
    List<Applicant> findAll();

    String deleteApplicant(Long id);

    Applicant updateApplicant(Applicant applicant, Long id);

    Applicant findById(Long id);
    
    Applicant save(Applicant applicant);
}
