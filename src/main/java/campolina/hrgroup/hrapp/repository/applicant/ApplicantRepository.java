package campolina.hrgroup.hrapp.repository.applicant;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.applicant.Applicant;

public interface ApplicantRepository extends CrudRepository<Applicant, Long>  {
    List<Applicant> findAll();

    Optional<Applicant> findByEmail(String email);
}

