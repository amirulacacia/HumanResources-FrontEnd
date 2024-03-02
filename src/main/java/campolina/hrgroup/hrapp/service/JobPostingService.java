package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.JobPosting;

@Service
public interface JobPostingService {
    
    JobPosting createJobPosting(JobPosting jobPosting);

    JobPosting getJobPostingById(Long jobPostingId);

    List<JobPosting> getAllJobPostings();

    JobPosting updateJobPosting(JobPosting jobPosting);

    String deleteJobPosting(Long jobPostingId);
}
