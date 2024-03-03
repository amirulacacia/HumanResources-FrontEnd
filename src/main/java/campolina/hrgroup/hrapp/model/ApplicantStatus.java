package campolina.hrgroup.hrapp.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "applicant_status")
public class ApplicantStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_status_id")
    private Long applicantStatusId;

    @Column(nullable = false, updatable = false, name = "application_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applicationDate;

    @NotBlank
    private String status;

    @NotBlank
    private Long fk_applicant_id;

    @NotBlank
    private Long fk_job_post_id;

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

    public Long getFk_applicant_id() {
        return fk_applicant_id;
    }
    
    public void setFk_applicant_id(Long fk_applicant_id) {
        this.fk_applicant_id = fk_applicant_id;
    }

    public Long getFk_job_post_id() {
        return fk_job_post_id;
    }
    
    public void setFk_job_post_id(Long fk_job_post_id) {
        this.fk_job_post_id = fk_job_post_id;
    }
}
