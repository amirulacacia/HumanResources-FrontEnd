package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.JobPosition;

public interface JobPositionRepository extends CrudRepository<JobPosition, Long>  {
    List<JobPosition> findAll();
}

