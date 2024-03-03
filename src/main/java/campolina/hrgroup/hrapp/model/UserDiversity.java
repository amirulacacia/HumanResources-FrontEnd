package campolina.hrgroup.hrapp.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
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
@Table(name = "user_diversity")
public class UserDiversity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_diversity_id")
    private Long userDiversityId;

    @NotBlank
    private String gender;

    @Column(nullable = false, name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @NotBlank
    @Column(name = "marital_status")
    private String maritalStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_applicant_id")
    private Applicant applicant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee_id")
    private Employee employee;

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Long getUserDiversityId() {
        return userDiversityId;
    }

    public void setUserDiversityId(Long userDiversityId) {
        this.userDiversityId = userDiversityId;
    }
}
