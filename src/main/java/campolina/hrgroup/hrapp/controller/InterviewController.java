package campolina.hrgroup.hrapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.Interview;
import campolina.hrgroup.hrapp.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping
    public Interview createInterview(@RequestBody Interview interview) {
        return interviewService.createInterview(interview);
    }

    @GetMapping("/{interviewId}")
    public Interview getInterviewById(@PathVariable Long interviewId) {
        return interviewService.getInterviewById(interviewId);
    }

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @PutMapping("/{interviewId}")
    public Interview updateInterview(@RequestBody Interview interview,
                                      @PathVariable Long interviewId) {
        return interviewService.updateInterview(interview);
    }

    @DeleteMapping("/{interviewId}")
    public String deleteInterview(@PathVariable Long interviewId) {
        return interviewService.deleteInterview(interviewId);
    }
}

