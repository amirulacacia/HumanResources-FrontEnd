package campolina.hrgroup.hrapp.service.serviceImplementation.information;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.information.Experience;
import campolina.hrgroup.hrapp.repository.applicant.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.employee.EmployeeRepository;
import campolina.hrgroup.hrapp.repository.information.ExperienceRepository;
import campolina.hrgroup.hrapp.service.information.ExperienceService;

@Service
@Transactional
public class ExperienceServiceImplementation implements ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Experience createExperience(Experience experience, String user, Long userId) {
        switch (user) {
            case "employee":
                experience.setEmployee(employeeRepository.findById(userId).get());
                break;
            case "applicant":
                experience.setApplicant(applicantRepository.findById(userId).get());
                break;
            default:
                break;
        }
        return experienceRepository.save(experience);
    }

    @Override
    public Experience getExperienceById(Long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience updateExperience(Experience experience, Long id) {
        Experience experienceDB = experienceRepository.findById(id).get();

        if (Objects.nonNull(experience.getEmployerName())) {
            experienceDB.setEmployerName(experience.getEmployerName());
        }

        if (Objects.nonNull(experience.getJobTitle())) {
            experienceDB.setJobTitle(experience.getJobTitle());
        }

        if (Objects.nonNull(experience.getStartDate())) {
            experienceDB.setStartDate(experience.getStartDate());
        }

        if (Objects.nonNull(experience.getEndDate())) {
            experienceDB.setEndDate(experience.getEndDate());
        }

        if (Objects.nonNull(experience.getEmployerAddress())) {
            experienceDB.setEmployerAddress(experience.getEmployerAddress());
        }

        if (Objects.nonNull(experience.getSalary())) {
            experienceDB.setSalary(experience.getSalary());
        }

        if (Objects.nonNull(experience.getJobDescription())) {
            experienceDB.setJobDescription(experience.getJobDescription());
        }

        return experienceRepository.save(experienceDB);
    }

    @Override
    public String deleteExperience(Long id) {
        experienceRepository.deleteById(id);
        return "Experience with ID: " + id + " has been deleted successfully";
    }
}
