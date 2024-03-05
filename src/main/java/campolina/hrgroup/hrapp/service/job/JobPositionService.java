package campolina.hrgroup.hrapp.service.job;

import java.util.List;
import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.job.JobPosition;

@Service
public interface JobPositionService {

    JobPosition createJobPosition(JobPosition jobPosition, Long departmentId);

    JobPosition getJobPositionById(Long id);

    List<JobPosition> getAllJobPositions();

    JobPosition updateJobPosition(JobPosition jobPosition, Long id);

    String deleteJobPosition(Long id);
}
