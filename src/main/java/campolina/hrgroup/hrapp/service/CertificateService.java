package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Certificate;

@Service
public interface CertificateService {
    
    Certificate createCertificate(Certificate certificate);

    Certificate getCertificateById(Long certificateId);

    List<Certificate> getAllCertificates();

    Certificate updateCertificate(Certificate certificate);

    String deleteCertificate(Long certificateId);
}
