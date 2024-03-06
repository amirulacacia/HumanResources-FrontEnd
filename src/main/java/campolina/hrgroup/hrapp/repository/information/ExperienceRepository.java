package campolina.hrgroup.hrapp.repository.information;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.information.Experience;

public interface ExperienceRepository extends CrudRepository<Experience, Long>  {
    List<Experience> findAll();
}

