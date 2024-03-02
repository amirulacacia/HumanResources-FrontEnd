package campolina.hrgroup.hrapp.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "applicant_status")
public class ApplicantStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicantStatus_id")
    private Long applicantStatusId;

    @Column(nullable = false, updatable = false, name = "application_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applicationDate;

    @NotBlank
    private String status;

    @OneToOne
    @JoinColumn(name = "applicantStatus_id", referencedColumnName = "applicantStatus_id")
    private ApplicantStatus applicantStatus;

    public Long getApplicantStatusId() {
        return applicantStatusId;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setApplicantStatusId(Long applicantStatusId) {
        this.applicantStatusId = applicantStatusId;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
