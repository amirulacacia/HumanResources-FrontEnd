package campolina.hrgroup.hrapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "job_posting")
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_post_id")
    private Long jobPostingId;

    @OneToOne
    @JoinColumn(name = "fk_position_id")
    private JobPosition jobPosition;

    @NotBlank
    private String location;

    @NotNull
    private Integer vacancy;

    @Column(name = "close_date")
    @Temporal(TemporalType.TIMESTAMP)
    private String closedDate;

    @Column(nullable = false, updatable = false, name = "upload_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private String uploadDate;

    @Column(name = "salary_offer")
    private Double salaryOffer;

    @NotBlank
    private String status;

    @ManyToMany(mappedBy = "jobStatus")
    private Set<Applicant> applicantStatus =  new HashSet<>();

    public Set<Applicant> getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(Set<Applicant> applicantStatus) {
        this.applicantStatus = applicantStatus;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    // public JobPosition getJobPosition() {
    //     return jobPosition;
    // }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }
    
    public Long getJobPostingId() {
        return jobPostingId;
    }

    public void setJobPostingId(Long jobPostingId) {
        this.jobPostingId = jobPostingId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getSalaryOffer() {
        return salaryOffer;
    }

    public void setSalaryOffer(Double salaryOffer) {
        this.salaryOffer = salaryOffer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getVacancy() {
        return vacancy;
    }

    public void setVacancy(Integer vacancy) {
        this.vacancy = vacancy;
    }
}
