package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.Education;
import campolina.hrgroup.hrapp.repository.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.EducationRepository;
import campolina.hrgroup.hrapp.repository.EmployeeRepository;
import campolina.hrgroup.hrapp.service.EducationService;

@Service
@Transactional
public class EducationServiceImplementation implements EducationService {
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Education createEducation(Education education, String user, Long userId) {
        switch (user) {
            case "employee":
                education.setEmployee(employeeRepository.findById(userId).get());
                break;
            case "applicant":
                education.setApplicant(applicantRepository.findById(userId).get());
                break;
            default:
                break;
        }
        return educationRepository.save(education);
    }

    @Override
    public Education getEducationById(Long id) {
        return educationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    @Override
    public Education updateEducation(Education education, Long id) {

        Education educationDB = educationRepository.findById(id).get();

        if (Objects.nonNull(education.getEducationLevel())) {
            educationDB.setEducationLevel(education.getEducationLevel());
        }

        if (Objects.nonNull(education.getMajor())) {
            educationDB.setMajor(education.getMajor());
        }

        if (Objects.nonNull(education.getSchool())) {
            educationDB.setSchool(education.getSchool());
        }

        if (Objects.nonNull(education.getStartDate())) {
            educationDB.setStartDate(education.getStartDate());
        }

        if (Objects.nonNull(education.getEndDate())) {
            educationDB.setEndDate(education.getEndDate());
        }

        if (Objects.nonNull(education.getCgpa())) {
            educationDB.setCgpa(education.getCgpa());
        }

        if (Objects.nonNull(education.getGraduationYear())) {
            educationDB.setGraduationYear(education.getGraduationYear());
        }

        return educationRepository.save(educationDB);
    }

    @Override
    public String deleteEducation(Long id) {
        educationRepository.deleteById(id);
        return "Education with ID: " + id + " has been deleted successfully";
    }
}

