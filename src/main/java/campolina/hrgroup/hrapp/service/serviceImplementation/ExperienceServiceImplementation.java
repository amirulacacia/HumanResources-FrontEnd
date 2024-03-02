package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.Experience;
import campolina.hrgroup.hrapp.repository.ExperienceRepository;
import campolina.hrgroup.hrapp.service.ExperienceService;

@Service
@Transactional
public class ExperienceServiceImplementation implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public Experience getExperienceById(Long experienceId) {
        return experienceRepository.findById(experienceId).orElse(null);
    }

    @Override
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience updateExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public String deleteExperience(Long experienceId) {
        experienceRepository.deleteById(experienceId);
        return "Experience with ID: " + experienceId + " has been deleted successfully";
    }
}

