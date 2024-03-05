package campolina.hrgroup.hrapp.repository.job;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.job.JobPosition;

public interface JobPositionRepository extends CrudRepository<JobPosition, Long>  {
    List<JobPosition> findAll();
}

