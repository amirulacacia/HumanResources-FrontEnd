package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.JobPosition;
import campolina.hrgroup.hrapp.repository.DepartmentRepository;
import campolina.hrgroup.hrapp.repository.JobPositionRepository;
import campolina.hrgroup.hrapp.service.JobPositionService;

@Service
@Transactional
public class JobPositionServiceImplementation implements JobPositionService {

    @Autowired
    private JobPositionRepository jobPositionRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public JobPosition createJobPosition(JobPosition jobPosition, Long departmentId) {
        jobPosition.setDepartment(departmentRepository.findById(departmentId).get());
        
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
    public JobPosition updateJobPosition(JobPosition jobPosition, Long id) {
        JobPosition jobPositionDB = jobPositionRepository.findById(id).get();

        if (Objects.nonNull(jobPosition.getName())) {
            jobPositionDB.setName(jobPosition.getName());
        }

        if (Objects.nonNull(jobPosition.getRequirement())) {
            jobPositionDB.setRequirement(jobPosition.getRequirement());
        }

        if (Objects.nonNull(jobPosition.getJobDescription())) {
            jobPositionDB.setJobDescription(jobPosition.getJobDescription());
        }


        return jobPositionRepository.save(jobPositionDB);
    }

    @Override
    public String deleteJobPosition(Long positionId) {
        jobPositionRepository.deleteById(positionId);
        return "Job position with ID: " + positionId + " has been deleted successfully";
    }
}

