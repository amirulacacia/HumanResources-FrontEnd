package campolina.hrgroup.hrapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private long applicantId;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @ManyToOne
    @JoinColumn(name = "jobPost_id")
    private JobPosting jobPosting;

    @OneToOne
    @JoinColumn(name = "applicantStatus_id")
    private ApplicantStatus applicantStatus;

    @OneToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private UserInfo userInfo;

    @OneToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private UserDiversity userDiversity;

    @OneToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private UserDocuments userDocuments;

    @OneToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private AdditionalInfo additionalInfo;

    @OneToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private Interview interview;

    @OneToMany
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private List<Skill> skills;

    @OneToMany
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private List<Certificate> certificates;

    @OneToMany
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private List<Education> educations;

    @OneToMany
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private List<Experience> experiences;

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
