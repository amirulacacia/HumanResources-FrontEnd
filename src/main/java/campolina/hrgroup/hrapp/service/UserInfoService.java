package campolina.hrgroup.hrapp.service;

import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.UserInfo;

@Service
public interface UserInfoService {

    UserInfo saveUserInfo(UserInfo userInfo);

    UserInfo getUserInfoById(Long id);

    String deleteUserInfo(Long id);
}
