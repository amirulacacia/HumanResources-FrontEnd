package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.JobPosting;
import campolina.hrgroup.hrapp.repository.JobPostingRepository;
import campolina.hrgroup.hrapp.service.JobPostingService;

@Service
@Transactional
public class JobPostingServiceImplementation implements JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Override
    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    @Override
    public JobPosting getJobPostingById(Long jobPostingId) {
        return jobPostingRepository.findById(jobPostingId).orElse(null);
    }

    @Override
    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    @Override
    public JobPosting updateJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    @Override
    public String deleteJobPosting(Long jobPostingId) {
        jobPostingRepository.deleteById(jobPostingId);
        return "Job posting with ID: " + jobPostingId + " has been deleted successfully";
    }
}

