package campolina.hrgroup.hrapp.service.information;

import java.util.List;
import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.information.UserDocuments;

@Service
public interface UserDocumentsService {

    UserDocuments createUserDocuments(UserDocuments userDocuments, String user, Long userId);

    UserDocuments getUserDocumentsById(Long id);

    List<UserDocuments> getAllUserDocuments();

    UserDocuments updateUserDocuments(UserDocuments userDocuments, Long id);

    String deleteUserDocuments(Long id);
}
