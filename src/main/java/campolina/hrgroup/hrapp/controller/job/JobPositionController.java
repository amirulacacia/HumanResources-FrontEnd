package campolina.hrgroup.hrapp.controller.job;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import campolina.hrgroup.hrapp.model.job.JobPosition;
import campolina.hrgroup.hrapp.service.job.JobPositionService;

@RestController
@RequestMapping("/jobPosition")
public class JobPositionController {

    @Autowired
    private JobPositionService jobPositionService;

    @PostMapping("/department/{departmentId}")
    public JobPosition createJobPosition(@RequestBody JobPosition jobPosition, @PathVariable Long departmentId) {
        return jobPositionService.createJobPosition(jobPosition, departmentId);
    }

    @GetMapping("/{positionId}")
    public JobPosition getJobPositionById(@PathVariable Long positionId) {
        return jobPositionService.getJobPositionById(positionId);
    }

    @GetMapping
    public List<JobPosition> getAllJobPositions() {
        return jobPositionService.getAllJobPositions();
    }

    @PutMapping("/{positionId}")
    public JobPosition updateJobPosition(@RequestBody JobPosition jobPosition,
            @PathVariable Long positionId) {
        return jobPositionService.updateJobPosition(jobPosition, positionId);
    }

    @DeleteMapping("/{positionId}")
    public String deleteJobPosition(@PathVariable Long positionId) {
        return jobPositionService.deleteJobPosition(positionId);
    }
}
