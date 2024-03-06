package campolina.hrgroup.hrapp.service.information;

import java.util.List;
import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.information.UserDiversity;

@Service
public interface UserDiversityService {
   
    UserDiversity createUserDiversity(UserDiversity userDiversity, String user, Long userId);

    UserDiversity getUserDiversityById(Long id);

    List<UserDiversity> getAllUserDiversities();

    UserDiversity updateUserDiversity(UserDiversity userDiversity, Long id);

    String deleteUserDiversity(Long id);
}
