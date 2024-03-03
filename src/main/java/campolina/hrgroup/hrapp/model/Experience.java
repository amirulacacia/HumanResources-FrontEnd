package campolina.hrgroup.hrapp.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private Long experienceId;

    @NotBlank
    @Column(name = "employer_name")
    private String employerName;

    @NotBlank
    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "employer_address")
    private String employerAddress;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "job_description")
    private String jobDescription;

    @ManyToOne
    @JoinColumn(name = "fk_applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "fk_employee_id")
    private Employee employee;

    // public Applicant getApplicant() {
    //     return applicant;
    // }

    // public Employee getEmployee() {
    //     return employee;
    // }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public String getEmployerName() {
        return employerName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Long getExperienceId() {
        return experienceId;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Double getSalary() {
        return salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setExperienceId(Long experienceId) {
        this.experienceId = experienceId;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
