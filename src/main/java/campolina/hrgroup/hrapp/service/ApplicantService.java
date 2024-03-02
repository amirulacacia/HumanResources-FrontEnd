package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Applicant;

@Service
public interface ApplicantService {
   
    List<Applicant> findAll();

    String deleteApplicant(Long id);

    Applicant updateApplicant(Applicant applicant, Long id);

    Applicant findById(Long id);

    Applicant save(Applicant applicant, Long id);
    
    Applicant save(Applicant applicant);
}
