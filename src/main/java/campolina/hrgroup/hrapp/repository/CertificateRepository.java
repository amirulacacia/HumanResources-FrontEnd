package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.Certificate;

public interface CertificateRepository extends CrudRepository<Certificate, Long>  {
    List<Certificate> findAll();
}

