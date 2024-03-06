package campolina.hrgroup.hrapp.service.serviceImplementation.job;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.job.JobPosition;
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

    @Override
    public JobPosting registerJobPosting(Map<String, String> map) {
        JobPosting jobPosting = new JobPosting();
        JobPosition jobPosition = new JobPosition();
        System.out.println("1");
        try {
            if (Objects.isNull(jobPositionRepository.findByName(map.get("jobPosition")).get())) {
                jobPosition.setName(map.get("jobPosition"));
                jobPosition.setJobDescription(map.get("jobDescription"));
                jobPosting.setJobPosition(jobPosition);
            }else{
                jobPosition = jobPositionRepository.findByName(map.get("jobPosition")).get();
                jobPosting.setJobPosition(jobPosition);
            }
        } catch (Exception e) {
            System.out.println("There are some error on finding job position");
        }
        
        System.out.println("2");

    //   jobPosition: [null, [Validators.required]],
    //   vacancy: [null, [Validators.required]],
    //   location: [null, [Validators.required]],
    //   salaryOffer: [null, [Validators.required]],
    //   jobDescription: [null, [Validators.required]],
    //   closingDate: [null, [Validators.required]],

        jobPosting.setLocation(map.get("location"));
        jobPosting.setVacancy(Integer.valueOf(map.get("vacancy")));
        jobPosting.setClosedDate(map.get("closingDate"));
        jobPosting.setSalaryOffer((double)Integer.valueOf(map.get("salaryOffer")));
        jobPosting.setStatus("Submitted");

        System.out.println("3");

        return jobPostingRepository.save(jobPosting);
    }
}

