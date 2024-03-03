package campolina.hrgroup.hrapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.UserInfo;

@Service
public interface UserInfoService {

    UserInfo saveUserInfo(UserInfo userInfo, String user, Long userId);

    List<UserInfo> getAllUserInfos();

    UserInfo getUserInfoById(Long id);

    UserInfo updateUserInfo(UserInfo userInfo, Long id);

    String deleteUserInfo(Long id);
}
