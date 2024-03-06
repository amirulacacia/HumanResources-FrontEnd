package campolina.hrgroup.hrapp.model.job;

import java.util.List;

import campolina.hrgroup.hrapp.model.employee.Employee;
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
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "job_position")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long positionId;

    @NotBlank
    private String name;

    @NotBlank
    @Column(name = "job_description")
    private String jobDescription;

    @NotBlank
    private String requirement;

    @ManyToOne
    @JoinColumn(name = "fk_department_id")
    private Department department;
    
    @OneToOne(mappedBy = "jobPosition")
    private JobPosting jobPosting;

    @OneToMany(mappedBy = "jobPosition")
    private List<Employee> employees;

    // public Department getDepartment() {
    //     return department;
    // }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }
    
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    // public List<Employee> getEmployees() {
    //     return employees;
    // }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}