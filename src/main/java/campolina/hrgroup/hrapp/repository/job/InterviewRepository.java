package campolina.hrgroup.hrapp.repository.job;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.job.Interview;

public interface InterviewRepository extends CrudRepository<Interview, Long>  {
    List<Interview> findAll();
}

