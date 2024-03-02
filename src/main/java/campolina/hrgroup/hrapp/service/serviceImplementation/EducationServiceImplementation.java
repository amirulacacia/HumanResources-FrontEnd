package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.Education;
import campolina.hrgroup.hrapp.repository.EducationRepository;
import campolina.hrgroup.hrapp.service.EducationService;

@Service
@Transactional
public class EducationServiceImplementation implements EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public Education getEducationById(Long educationId) {
        return educationRepository.findById(educationId).orElse(null);
    }

    @Override
    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    @Override
    public Education updateEducation(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public String deleteEducation(Long educationId) {
        educationRepository.deleteById(educationId);
        return "Education with ID: " + educationId + " has been deleted successfully";
    }
}

