package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.Interview;
import campolina.hrgroup.hrapp.repository.InterviewRepository;
import campolina.hrgroup.hrapp.service.InterviewService;

@Service
@Transactional
public class InterviewServiceImplementation implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public Interview getInterviewById(Long interviewId) {
        return interviewRepository.findById(interviewId).orElse(null);
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview updateInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public String deleteInterview(Long interviewId) {
        interviewRepository.deleteById(interviewId);
        return "Interview with ID: " + interviewId + " has been deleted successfully";
    }
}

