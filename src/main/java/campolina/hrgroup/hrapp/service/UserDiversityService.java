package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.UserDiversity;

@Service
public interface UserDiversityService {
   
    UserDiversity createUserDiversity(UserDiversity userDiversity);

    UserDiversity getUserDiversityById(Long userDiversityId);

    List<UserDiversity> getAllUserDiversities();

    UserDiversity updateUserDiversity(UserDiversity userDiversity);

    String deleteUserDiversity(Long userDiversityId);
}
