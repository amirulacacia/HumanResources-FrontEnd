package campolina.hrgroup.hrapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "additional_info")
public class AdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additionalInfo_id")
    private Long additionInfoId;

    @Column(name = "relocation")
    private Boolean relocation;

    @Column(name = "expected_salary")
    private Double expectedSalary;

    @Column(name = "notice_period")
    private Integer noticePeriod;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany
    @JoinColumn(name = "additionalInfo_id", referencedColumnName = "additionalInfo_id")
    private List<Reference> references;

    public Long getAdditionInfoId() {
        return additionInfoId;
    }

    public void setAdditionInfoId(Long additionInfoId) {
        this.additionInfoId = additionInfoId;
    }

    public Double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(Double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public Integer getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(Integer noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Boolean getRelocation() {
        return relocation;
    }

    public void setRelocation(Boolean relocation) {
        this.relocation = relocation;
    }
}
