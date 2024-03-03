package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Certificate;

@Service
public interface CertificateService {
    
    Certificate createCertificate(Certificate certificate, String user, Long userId);

    Certificate getCertificateById(Long id);

    List<Certificate> getAllCertificates();

    Certificate updateCertificate(Certificate certificate, Long id);

    String deleteCertificate(Long id);
}
