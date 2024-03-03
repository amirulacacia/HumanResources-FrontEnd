package campolina.hrgroup.hrapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.Certificate;
import campolina.hrgroup.hrapp.service.CertificateService;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @PostMapping("{user}/{userId}")
    public Certificate createCertificate(@RequestBody Certificate certificate,
            @PathVariable("user") String user, @PathVariable("userId") Long userId) {
        return certificateService.createCertificate(certificate, user, userId);
    }

    @GetMapping("/{certificateId}")
    public Certificate getCertificateById(@PathVariable Long certificateId) {
        return certificateService.getCertificateById(certificateId);
    }

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @PutMapping("/{certificateId}")
    public Certificate updateCertificate(@RequestBody Certificate certificate,
            @PathVariable Long certificateId) {
        return certificateService.updateCertificate(certificate, certificateId);
    }

    @DeleteMapping("/{certificateId}")
    public String deleteCertificate(@PathVariable Long certificateId) {
        return certificateService.deleteCertificate(certificateId);
    }
}
