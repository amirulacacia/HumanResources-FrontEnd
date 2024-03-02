package campolina.hrgroup.hrapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long employeeId;

    @NotBlank
    private String password;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private UserInfo userInfo;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private UserDiversity userDiversity;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private UserDocuments userDocuments;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private AdditionalInfo additionalInfo;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Address address;

    @OneToMany
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private List<Skill> skills;

    @OneToMany
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private List<Certificate> certificates;

    @OneToMany
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private List<Education> educations;

    @OneToMany
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private List<Experience> experiences;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private JobPosition jobPosition;

    @ManyToMany
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private List<Interview> interviews;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
