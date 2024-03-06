package campolina.hrgroup.hrapp.service.job;

import java.util.List;
import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.job.Interview;

@Service
public interface InterviewService {

    Interview createInterview(Interview interview, Long applicantId);

    Interview getInterviewById(Long id);

    List<Interview> getAllInterviews();

    Interview updateInterview(Interview interview, Long id);

    String deleteInterview(Long id);
}
