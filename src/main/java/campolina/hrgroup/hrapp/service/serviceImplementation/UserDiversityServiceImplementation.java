package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.UserDiversity;
import campolina.hrgroup.hrapp.repository.UserDiversityRepository;
import campolina.hrgroup.hrapp.service.UserDiversityService;

@Service
@Transactional
public class UserDiversityServiceImplementation implements UserDiversityService {

    @Autowired
    private UserDiversityRepository userDiversityRepository;

    @Override
    public UserDiversity createUserDiversity(UserDiversity userDiversity) {
        return userDiversityRepository.save(userDiversity);
    }

    @Override
    public UserDiversity getUserDiversityById(Long userDiversityId) {
        return userDiversityRepository.findById(userDiversityId).orElse(null);
    }

    @Override
    public List<UserDiversity> getAllUserDiversities() {
        return userDiversityRepository.findAll();
    }

    @Override
    public UserDiversity updateUserDiversity(UserDiversity userDiversity) {
        return userDiversityRepository.save(userDiversity);
    }

    @Override
    public String deleteUserDiversity(Long userDiversityId) {
        userDiversityRepository.deleteById(userDiversityId);
        return "User diversity with ID: " + userDiversityId + " has been deleted successfully";
    }
}

