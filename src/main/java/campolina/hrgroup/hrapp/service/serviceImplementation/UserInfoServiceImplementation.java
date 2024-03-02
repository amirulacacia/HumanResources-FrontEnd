package campolina.hrgroup.hrapp.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.UserInfo;
import campolina.hrgroup.hrapp.repository.UserInfoRepository;
import campolina.hrgroup.hrapp.service.UserInfoService;

@Service
public class UserInfoServiceImplementation implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
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
}

