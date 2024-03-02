package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.JobPosition;

@Service
public interface JobPositionService {

    JobPosition createJobPosition(JobPosition jobPosition);

    JobPosition getJobPositionById(Long positionId);

    List<JobPosition> getAllJobPositions();

    JobPosition updateJobPosition(JobPosition jobPosition);

    String deleteJobPosition(Long positionId);
}
