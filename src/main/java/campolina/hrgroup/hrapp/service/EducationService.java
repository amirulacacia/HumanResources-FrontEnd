package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Education;

@Service
public interface EducationService {

    Education createEducation(Education education);

    Education getEducationById(Long educationId);

    List<Education> getAllEducations();

    Education updateEducation(Education education);

    String deleteEducation(Long educationId);
}
