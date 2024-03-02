package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.Applicant;

public interface ApplicantRepository extends CrudRepository<Applicant, Long>  {
    List<Applicant> findAll();
}

