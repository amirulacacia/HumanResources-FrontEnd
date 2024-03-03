package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.UserDocuments;
import campolina.hrgroup.hrapp.repository.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.EmployeeRepository;
import campolina.hrgroup.hrapp.repository.UserDocumentsRepository;
import campolina.hrgroup.hrapp.service.UserDocumentsService;

@Service
@Transactional
public class UserDocumentsServiceImplementation implements UserDocumentsService {

    @Autowired
    private UserDocumentsRepository userDocumentsRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public UserDocuments createUserDocuments(UserDocuments userDocuments, String user, Long userId) {
        switch (user) {
            case "employee":
                userDocuments.setEmployee(employeeRepository.findById(userId).get());
                break;
            case "applicant":
                userDocuments.setApplicant(applicantRepository.findById(userId).get());
                break;
            default:
                break;
        }
        return userDocumentsRepository.save(userDocuments);
    }

    @Override
    public UserDocuments getUserDocumentsById(Long id) {
        return userDocumentsRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserDocuments> getAllUserDocuments() {
        return userDocumentsRepository.findAll();
    }

    @Override
    public UserDocuments updateUserDocuments(UserDocuments userDocuments, Long id) {
        UserDocuments userDocumentsDB = userDocumentsRepository.findById(id).get();

        if (Objects.nonNull(userDocuments.getResumeLocation())) {
            userDocumentsDB.setResumeLocation(userDocuments.getResumeLocation());
        }

        if (Objects.nonNull(userDocuments.getCoverLetterLocation())) {
            userDocumentsDB.setCoverLetterLocation(userDocuments.getCoverLetterLocation());
        }

        if (Objects.nonNull(userDocuments.getLink())) {
            userDocumentsDB.setLink(userDocuments.getLink());
        }

        return userDocumentsRepository.save(userDocumentsDB);
    }

    @Override
    public String deleteUserDocuments(Long id) {
        userDocumentsRepository.deleteById(id);
        return "User documents with ID: " + id + " has been deleted successfully";
    }
}

