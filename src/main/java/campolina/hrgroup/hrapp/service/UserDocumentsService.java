package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.UserDocuments;

@Service
public interface UserDocumentsService {

    UserDocuments createUserDocuments(UserDocuments userDocuments);

    UserDocuments getUserDocumentsById(Long userDocumentsId);

    List<UserDocuments> getAllUserDocuments();

    UserDocuments updateUserDocuments(UserDocuments userDocuments);

    String deleteUserDocuments(Long userDocumentsId);
}
