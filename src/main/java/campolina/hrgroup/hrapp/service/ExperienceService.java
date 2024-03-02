package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Experience;

@Service
public interface ExperienceService {

    Experience createExperience(Experience experience);

    Experience getExperienceById(Long experienceId);

    List<Experience> getAllExperiences();

    Experience updateExperience(Experience experience);

    String deleteExperience(Long experienceId);
}
