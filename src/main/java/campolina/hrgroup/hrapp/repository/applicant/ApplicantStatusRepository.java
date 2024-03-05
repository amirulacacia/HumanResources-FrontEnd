package campolina.hrgroup.hrapp.repository.applicant;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.applicant.ApplicantStatus;

public interface ApplicantStatusRepository extends CrudRepository<ApplicantStatus, Long>  {
    List<ApplicantStatus> findAll();
}

