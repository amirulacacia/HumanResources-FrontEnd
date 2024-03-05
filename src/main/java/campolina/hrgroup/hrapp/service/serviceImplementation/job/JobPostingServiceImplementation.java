package campolina.hrgroup.hrapp.service.serviceImplementation.job;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.job.JobPosting;
import campolina.hrgroup.hrapp.repository.job.JobPositionRepository;
import campolina.hrgroup.hrapp.repository.job.JobPostingRepository;
import campolina.hrgroup.hrapp.service.job.JobPostingService;

@Service
@Transactional
public class JobPostingServiceImplementation implements JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;
    @Autowired
    private JobPositionRepository jobPositionRepository;

    @Override
    public JobPosting createJobPosting(JobPosting jobPosting, Long jobPositionId) {
        jobPosting.setJobPosition(jobPositionRepository.findById(jobPositionId).get());
        return jobPostingRepository.save(jobPosting);
    }

    @Override
    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    @Override
    public JobPosting updateJobPosting(JobPosting jobPosting, Long id) {
        JobPosting jobPostingDB = jobPostingRepository.findById(id).get();

        if (Objects.nonNull(jobPosting.getLocation())) {
            jobPostingDB.setLocation(jobPosting.getLocation());
        }

        if (Objects.nonNull(jobPosting.getVacancy())) {
            jobPostingDB.setVacancy(jobPosting.getVacancy());
        }

        if (Objects.nonNull(jobPosting.getClosedDate())) {
            jobPostingDB.setClosedDate(jobPosting.getClosedDate());
        }

        if (Objects.nonNull(jobPosting.getSalaryOffer())) {
            jobPostingDB.setSalaryOffer(jobPosting.getSalaryOffer());
        }

        if (Objects.nonNull(jobPosting.getStatus())) {
            jobPostingDB.setStatus(jobPosting.getStatus());
        }

        return jobPostingRepository.save(jobPostingDB);
    }

    @Override
    public String deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
        return "Job posting with ID: " + id + " has been deleted successfully";
    }
}

