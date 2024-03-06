package campolina.hrgroup.hrapp.service.serviceImplementation.job;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.job.Interview;
import campolina.hrgroup.hrapp.repository.applicant.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.job.InterviewRepository;
import campolina.hrgroup.hrapp.service.job.InterviewService;

@Service
@Transactional
public class InterviewServiceImplementation implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Interview createInterview(Interview interview, Long applicantId) {
        interview.setApplicant(applicantRepository.findById(applicantId).get());
        return interviewRepository.save(interview);
    }

    @Override
    public Interview getInterviewById(Long id) {
        return interviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview updateInterview(Interview interview, Long id) {
        Interview interviewDB = interviewRepository.findById(id).get();

        if (Objects.nonNull(interview.getPlatform())) {
            interviewDB.setPlatform(interview.getPlatform());
        }

        if (Objects.nonNull(interview.getAppointmentDate())) {
            interviewDB.setAppointmentDate(interview.getAppointmentDate());
        }

        if (Objects.nonNull(interview.getAppointmentTime())) {
            interviewDB.setAppointmentTime(interview.getAppointmentTime());
        }

        return interviewRepository.save(interviewDB);
    }

    @Override
    public String deleteInterview(Long id) {
        interviewRepository.deleteById(id);
        return "Interview with ID: " + id + " has been deleted successfully";
    }
}

