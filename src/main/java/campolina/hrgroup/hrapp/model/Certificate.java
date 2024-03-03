package campolina.hrgroup.hrapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Long certificateId;

    @NotBlank
    @Column(name = "certificate_location")
    private String certificateLocation;

    @ManyToOne
    @JoinColumn(name = "fk_applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "fk_employee_id")
    private Employee employee;

    public Applicant getApplicant() {
        return applicant;
    }

    public String getCertificateLocation() {
        return certificateLocation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setCertificateLocation(String certificateLocation) {
        this.certificateLocation = certificateLocation;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }
}
