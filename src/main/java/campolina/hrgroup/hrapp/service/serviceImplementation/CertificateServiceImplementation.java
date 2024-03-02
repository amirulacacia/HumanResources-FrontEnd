package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Certificate;
import campolina.hrgroup.hrapp.repository.CertificateRepository;
import campolina.hrgroup.hrapp.service.CertificateService;

@Service
public class CertificateServiceImplementation implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public Certificate createCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificateById(Long certificateId) {
        return certificateRepository.findById(certificateId).orElse(null);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public Certificate updateCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public String deleteCertificate(Long certificateId) {
        certificateRepository.deleteById(certificateId);
        return "Certificate with ID: " + certificateId + " has been deleted successfully";
    }
}

