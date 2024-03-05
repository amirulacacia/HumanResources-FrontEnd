package campolina.hrgroup.hrapp.repository.applicant;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.applicant.Applicant;

public interface ApplicantRepository extends CrudRepository<Applicant, Long>  {
    List<Applicant> findAll();
}

