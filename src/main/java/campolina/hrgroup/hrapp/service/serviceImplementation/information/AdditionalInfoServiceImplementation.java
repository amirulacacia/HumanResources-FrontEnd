package campolina.hrgroup.hrapp.service.serviceImplementation.information;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.information.AdditionalInfo;
import campolina.hrgroup.hrapp.repository.applicant.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.employee.EmployeeRepository;
import campolina.hrgroup.hrapp.repository.information.AdditionalInfoRepository;
import campolina.hrgroup.hrapp.service.information.AdditionalInfoService;

@Service
@Transactional
public class AdditionalInfoServiceImplementation implements AdditionalInfoService {
    @Autowired
    private AdditionalInfoRepository additionalInfoRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public AdditionalInfo createAdditionalInfo(AdditionalInfo additionalInfo, String user, Long userId) {
        switch (user) {
            case "employee":
                additionalInfo.setEmployee(employeeRepository.findById(userId).get());
                break;
            case "applicant":
                additionalInfo.setApplicant(applicantRepository.findById(userId).get());
                break;
            default:
                break;
        }
        return additionalInfoRepository.save(additionalInfo);
    }

    @Override
    public AdditionalInfo getAdditionalInfoById(Long id) {
        return additionalInfoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is no AdditionalInfo of this id"));
    }

    @Override
    public List<AdditionalInfo> getAllAdditionalInfo() {
        return additionalInfoRepository.findAll();
    }

    @Override
    public AdditionalInfo updateAdditionalInfo(AdditionalInfo additionalInfo, Long id) {
        AdditionalInfo additionalInfoDB = additionalInfoRepository.findById(id).get();

        if (Objects.nonNull(additionalInfo.getRelocation())) {
            additionalInfoDB.setRelocation(additionalInfo.getRelocation());
        }

        if (Objects.nonNull(additionalInfo.getExpectedSalary())) {
            additionalInfoDB.setExpectedSalary(additionalInfo.getExpectedSalary());
        }

        if (Objects.nonNull(additionalInfo.getNoticePeriod())) {
            additionalInfoDB.setNoticePeriod(additionalInfo.getNoticePeriod());
        }

        return additionalInfoRepository.save(additionalInfoDB);
    }

    @Override
    public String deleteAdditionalInfo(Long id) {
        additionalInfoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is no AdditionalInfo of this id to be delete"));

        additionalInfoRepository.deleteById(id);

        return "AdditionalInfo with ID: " + id + " has been deleted successfully";
    }
}
