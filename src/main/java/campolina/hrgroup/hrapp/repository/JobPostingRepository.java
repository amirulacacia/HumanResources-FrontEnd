package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.JobPosting;

public interface JobPostingRepository extends CrudRepository<JobPosting, Long>  {
    List<JobPosting> findAll();
}

