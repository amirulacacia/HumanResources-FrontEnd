package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.JobPosting;

@Service
public interface JobPostingService {
    
    JobPosting createJobPosting(JobPosting jobPosting, Long jobPositionId);

    JobPosting getJobPostingById(Long id);

    List<JobPosting> getAllJobPostings();

    JobPosting updateJobPosting(JobPosting jobPosting, Long id);

    String deleteJobPosting(Long id);
}
