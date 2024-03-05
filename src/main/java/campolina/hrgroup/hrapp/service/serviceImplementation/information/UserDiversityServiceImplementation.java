package campolina.hrgroup.hrapp.service.serviceImplementation.information;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.information.UserDiversity;
import campolina.hrgroup.hrapp.repository.applicant.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.employee.EmployeeRepository;
import campolina.hrgroup.hrapp.repository.information.UserDiversityRepository;
import campolina.hrgroup.hrapp.service.information.UserDiversityService;

@Service
@Transactional
public class UserDiversityServiceImplementation implements UserDiversityService {

    @Autowired
    private UserDiversityRepository userDiversityRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public UserDiversity createUserDiversity(UserDiversity userDiversity, String user, Long userId) {
        switch (user) {
            case "employee":
                userDiversity.setEmployee(employeeRepository.findById(userId).get());
                break;
            case "applicant":
                userDiversity.setApplicant(applicantRepository.findById(userId).get());
                break;
            default:
                break;
        }
        return userDiversityRepository.save(userDiversity);
    }

    @Override
    public UserDiversity getUserDiversityById(Long id) {
        return userDiversityRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserDiversity> getAllUserDiversities() {
        return userDiversityRepository.findAll();
    }

    @Override
    public UserDiversity updateUserDiversity(UserDiversity userDiversity, Long id) {
        UserDiversity userDiversityDB = userDiversityRepository.findById(id).get();

        if (Objects.nonNull(userDiversity.getGender())) {
            userDiversityDB.setGender(userDiversity.getGender());
        }

        if (Objects.nonNull(userDiversity.getBirthDate())) {
            userDiversityDB.setBirthDate(userDiversity.getBirthDate());
        }

        if (Objects.nonNull(userDiversity.getMaritalStatus())) {
            userDiversityDB.setMaritalStatus(userDiversity.getMaritalStatus());
        }

        return userDiversityRepository.save(userDiversityDB);
    }

    @Override
    public String deleteUserDiversity(Long id) {
        userDiversityRepository.deleteById(id);
        return "User diversity with ID: " + id + " has been deleted successfully";
    }
}

