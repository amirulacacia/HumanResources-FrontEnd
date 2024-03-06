package campolina.hrgroup.hrapp.service.information;

import java.util.List;
import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.information.Experience;

@Service
public interface ExperienceService {

    Experience createExperience(Experience experience, String user, Long userId);

    Experience getExperienceById(Long id);

    List<Experience> getAllExperiences();

    Experience updateExperience(Experience experience, Long id);

    String deleteExperience(Long id);
}
