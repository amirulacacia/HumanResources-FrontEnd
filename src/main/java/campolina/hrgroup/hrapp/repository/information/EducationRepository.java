package campolina.hrgroup.hrapp.repository.information;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.information.Education;

public interface EducationRepository extends CrudRepository<Education, Long>  {
    List<Education> findAll();
}

