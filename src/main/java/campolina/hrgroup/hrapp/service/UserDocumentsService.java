package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.UserDocuments;

@Service
public interface UserDocumentsService {

    UserDocuments createUserDocuments(UserDocuments userDocuments, String user, Long userId);

    UserDocuments getUserDocumentsById(Long id);

    List<UserDocuments> getAllUserDocuments();

    UserDocuments updateUserDocuments(UserDocuments userDocuments, Long id);

    String deleteUserDocuments(Long id);
}
