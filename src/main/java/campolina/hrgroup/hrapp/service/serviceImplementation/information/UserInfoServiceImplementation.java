package campolina.hrgroup.hrapp.service.serviceImplementation.information;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.information.UserInfo;
import campolina.hrgroup.hrapp.repository.applicant.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.employee.EmployeeRepository;
import campolina.hrgroup.hrapp.repository.information.UserInfoRepository;
import campolina.hrgroup.hrapp.service.information.UserInfoService;

@Service
@Transactional
public class UserInfoServiceImplementation implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo, String user, Long userId) {
        switch (user) {
            case "employee":
                userInfo.setEmployee(employeeRepository.findById(userId).get());
                break;
            case "applicant":
                userInfo.setApplicant(applicantRepository.findById(userId).get());
                break;
            default:
                break;
        }
        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(Long id) {
        return userInfoRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteUserInfo(Long id) {
        userInfoRepository.deleteById(id);
        return "User information with ID: " + id + " has been deleted successfully";
    }

    @Override
    public List<UserInfo> getAllUserInfos() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo updateUserInfo(UserInfo userInfo, Long id) {
        UserInfo userInfoDB = userInfoRepository.findById(id).get();

        if (Objects.nonNull(userInfo.getFirstName())) {
            userInfoDB.setFirstName(userInfo.getFirstName());
        }

        if (Objects.nonNull(userInfo.getLastName())) {
            userInfoDB.setLastName(userInfo.getLastName());
        }

        if (Objects.nonNull(userInfo.getTitle())) {
            userInfoDB.setTitle(userInfo.getTitle());
        }

        if (Objects.nonNull(userInfo.getMiddleName())) {
            userInfoDB.setMiddleName(userInfo.getMiddleName());
        }

        if (Objects.nonNull(userInfo.getContactNum())) {
            userInfoDB.setContactNum(userInfo.getContactNum());
        }

        return userInfoRepository.save(userInfoDB);
    }
}

