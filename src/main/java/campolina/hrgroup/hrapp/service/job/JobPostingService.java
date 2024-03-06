package campolina.hrgroup.hrapp.service.job;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.job.JobPosting;

@Service
public interface JobPostingService {
    
    JobPosting createJobPosting(JobPosting jobPosting, Long jobPositionId);

    JobPosting getJobPostingById(Long id);

    List<JobPosting> getAllJobPostings();

    JobPosting updateJobPosting(JobPosting jobPosting, Long id);

    String deleteJobPosting(Long id);

    JobPosting registerJobPosting(Map<String, String> map);
}
