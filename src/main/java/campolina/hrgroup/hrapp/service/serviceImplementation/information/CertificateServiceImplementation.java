package campolina.hrgroup.hrapp.service.serviceImplementation.information;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.information.Certificate;
import campolina.hrgroup.hrapp.repository.applicant.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.employee.EmployeeRepository;
import campolina.hrgroup.hrapp.repository.information.CertificateRepository;
import campolina.hrgroup.hrapp.service.information.CertificateService;

@Service
@Transactional
public class CertificateServiceImplementation implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Certificate createCertificate(Certificate certificate, String user, Long userId) {
        switch (user) {
            case "employee":
                certificate.setEmployee(employeeRepository.findById(userId).get());
                break;
            case "applicant":
                certificate.setApplicant(applicantRepository.findById(userId).get());
                break;
            default:
                break;
        }
        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificateById(Long id) {
        return certificateRepository.findById(id).orElse(null);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public Certificate updateCertificate(Certificate certificate, Long id) {
        Certificate certificateDB = certificateRepository.findById(id).get();

        if (Objects.nonNull(certificate.getCertificateLocation())) {
            certificateDB.setCertificateLocation(certificate.getCertificateLocation());
        }

        return certificateRepository.save(certificateDB);
    }

    @Override
    public String deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
        return "Certificate with ID: " + id + " has been deleted successfully";
    }
}

