package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Education;

@Service
public interface EducationService {

    Education createEducation(Education education, String user, Long userId);

    Education getEducationById(Long id);

    List<Education> getAllEducations();

    Education updateEducation(Education education, Long id);

    String deleteEducation(Long id);
}
