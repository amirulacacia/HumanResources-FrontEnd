package campolina.hrgroup.hrapp.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "job_posting")
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobPostingId;

    @NotNull
    private int positionId;

    @NotBlank
    private String location;

    @NotNull
    private int vacancy;

    @NotBlank
    private Date closedDate;

    @NotBlank
    private Date uploadDate;

    @NotBlank
    private double salaryOffer;

    @NotBlank
    private String status;

    public int getJobPostingId() {
        return jobPostingId;
    }

    public void setJobPostingId(int jobPostingId) {
        this.jobPostingId = jobPostingId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public double getSalaryOffer() {
        return salaryOffer;
    }

    public void setSalaryOffer(double salaryOffer) {
        this.salaryOffer = salaryOffer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
