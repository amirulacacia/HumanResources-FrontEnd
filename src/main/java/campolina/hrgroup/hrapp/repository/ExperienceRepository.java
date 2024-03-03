package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.Experience;

public interface ExperienceRepository extends CrudRepository<Experience, Long>  {
    List<Experience> findAll();
}

