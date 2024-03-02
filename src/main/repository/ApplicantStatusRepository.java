package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.ApplicantStatus;

public interface ApplicantStatusRepository extends CrudRepository<ApplicantStatus, Long>  {
    List<ApplicantStatus> findAll();
}

