package campolina.hrgroup.hrapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicantId;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @OneToOne
    private JobPosting jobPosting;

    @OneToOne
    private ApplicantStatus applicantStatus;

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public ApplicantStatus getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(ApplicantStatus applicantStatus) {
        this.applicantStatus = applicantStatus;
    }
}
