package campolina.hrgroup.hrapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.JobPosting;
import campolina.hrgroup.hrapp.service.JobPostingService;

@RestController
@RequestMapping("/jobPosting")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @PostMapping
    public JobPosting createJobPosting(@RequestBody JobPosting jobPosting) {
        return jobPostingService.createJobPosting(jobPosting);
    }

    @GetMapping("/{jobPostingId}")
    public JobPosting getJobPostingById(@PathVariable Long jobPostingId) {
        return jobPostingService.getJobPostingById(jobPostingId);
    }

    @GetMapping
    public List<JobPosting> getAllJobPostings() {
        return jobPostingService.getAllJobPostings();
    }

    @PutMapping("/{jobPostingId}")
    public JobPosting updateJobPosting(@RequestBody JobPosting jobPosting,
                                       @PathVariable Long jobPostingId) {
        return jobPostingService.updateJobPosting(jobPosting);
    }

    @DeleteMapping("/{jobPostingId}")
    public String deleteJobPosting(@PathVariable Long jobPostingId) {
        return jobPostingService.deleteJobPosting(jobPostingId);
    }
}

