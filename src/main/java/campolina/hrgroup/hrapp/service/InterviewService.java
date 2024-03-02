package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Interview;

@Service
public interface InterviewService {

    Interview createInterview(Interview interview);

    Interview getInterviewById(Long interviewId);

    List<Interview> getAllInterviews();

    Interview updateInterview(Interview interview);

    String deleteInterview(Long interviewId);
}
