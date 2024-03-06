package campolina.hrgroup.hrapp.repository.information;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.information.UserDocuments;

public interface UserDocumentsRepository extends CrudRepository<UserDocuments, Long>  {
    List<UserDocuments> findAll();
}

