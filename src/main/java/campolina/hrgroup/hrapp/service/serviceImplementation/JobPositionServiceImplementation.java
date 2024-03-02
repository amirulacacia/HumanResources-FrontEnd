package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.JobPosition;
import campolina.hrgroup.hrapp.repository.JobPositionRepository;
import campolina.hrgroup.hrapp.service.JobPositionService;

@Service
public class JobPositionServiceImplementation implements JobPositionService {

    @Autowired
    private JobPositionRepository jobPositionRepository;

    @Override
    public JobPosition createJobPosition(JobPosition jobPosition) {
        return jobPositionRepository.save(jobPosition);
    }

    @Override
    public JobPosition getJobPositionById(Long positionId) {
        return jobPositionRepository.findById(positionId).orElse(null);
    }

    @Override
    public List<JobPosition> getAllJobPositions() {
        return jobPositionRepository.findAll();
    }

    @Override
    public JobPosition updateJobPosition(JobPosition jobPosition) {
        return jobPositionRepository.save(jobPosition);
    }

    @Override
    public String deleteJobPosition(Long positionId) {
        jobPositionRepository.deleteById(positionId);
        return "Job position with ID: " + positionId + " has been deleted successfully";
    }
}

