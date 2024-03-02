package campolina.hrgroup.hrapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "additional_info")
public class AdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long additionInfoId;

    private boolean relocation;

    private String references;

    private double expectedSalary;

    private int noticePeriod;

    @OneToOne
    private Applicant applicant;

    @OneToOne
    private Employee employee;

    public long getAdditionInfoId() {
        return additionInfoId;
    }

    public void setAdditionInfoId(long additionInfoId) {
        this.additionInfoId = additionInfoId;
    }

    public boolean isRelocation() {
        return relocation;
    }

    public void setRelocation(boolean relocation) {
        this.relocation = relocation;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public int getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(int noticePeriod) {
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
}
