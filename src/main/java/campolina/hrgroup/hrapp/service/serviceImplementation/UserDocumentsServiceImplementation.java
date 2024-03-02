package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.UserDocuments;
import campolina.hrgroup.hrapp.repository.UserDocumentsRepository;
import campolina.hrgroup.hrapp.service.UserDocumentsService;

@Service
public class UserDocumentsServiceImplementation implements UserDocumentsService {

    @Autowired
    private UserDocumentsRepository userDocumentsRepository;

    @Override
    public UserDocuments createUserDocuments(UserDocuments userDocuments) {
        return userDocumentsRepository.save(userDocuments);
    }

    @Override
    public UserDocuments getUserDocumentsById(Long userDocumentsId) {
        return userDocumentsRepository.findById(userDocumentsId).orElse(null);
    }

    @Override
    public List<UserDocuments> getAllUserDocuments() {
        return userDocumentsRepository.findAll();
    }

    @Override
    public UserDocuments updateUserDocuments(UserDocuments userDocuments) {
        return userDocumentsRepository.save(userDocuments);
    }

    @Override
    public String deleteUserDocuments(Long userDocumentsId) {
        userDocumentsRepository.deleteById(userDocumentsId);
        return "User documents with ID: " + userDocumentsId + " has been deleted successfully";
    }
}

