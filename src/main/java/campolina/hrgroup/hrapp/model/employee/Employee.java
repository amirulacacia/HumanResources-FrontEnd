package campolina.hrgroup.hrapp.model.employee;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import campolina.hrgroup.hrapp.model.information.AdditionalInfo;
import campolina.hrgroup.hrapp.model.information.Address;
import campolina.hrgroup.hrapp.model.information.Certificate;
import campolina.hrgroup.hrapp.model.information.Education;
import campolina.hrgroup.hrapp.model.information.Experience;
import campolina.hrgroup.hrapp.model.information.Skill;
import campolina.hrgroup.hrapp.model.information.UserDiversity;
import campolina.hrgroup.hrapp.model.information.UserDocuments;
import campolina.hrgroup.hrapp.model.information.UserInfo;
import campolina.hrgroup.hrapp.model.job.Interview;
import campolina.hrgroup.hrapp.model.job.JobPosition;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
    private Long employeeId;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @OneToOne(mappedBy = "employee")
    private UserInfo userInfo;

    @OneToOne(mappedBy = "employee")
    private UserDiversity userDiversity;

    @OneToOne(mappedBy = "employee")
    private UserDocuments userDocuments;

    @OneToOne(mappedBy = "employee")
    private AdditionalInfo additionalInfo;

    @OneToOne(mappedBy = "employee")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee_id", referencedColumnName = "employee_id")
    private List<Skill> skills;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee_id", referencedColumnName = "employee_id")
    private List<Certificate> certificates;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee_id", referencedColumnName = "employee_id")
    private List<Education> educations;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee_id", referencedColumnName = "employee_id")
    private List<Experience> experiences;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
        name = "employee_position",
        joinColumns = @JoinColumn(name = "fk_employee_id"),
        inverseJoinColumns = @JoinColumn(name = "fk_position_id")
    )
    private JobPosition jobPosition;

    @ManyToMany
    @JoinTable(
        name = "employee_interview",
        joinColumns = @JoinColumn(name = "fk_employee_id"),
        inverseJoinColumns = @JoinColumn(name = "fk_interview_id")
    )
    private Set<Interview> assignInterview = new HashSet<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Interview> getAssignInterview() {
        return assignInterview;
    }

    public void setAssignInterview(Set<Interview> assignInterview) {
        this.assignInterview = assignInterview;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public UserDiversity getUserDiversity() {
        return userDiversity;
    }

    public void setUserDiversity(UserDiversity userDiversity) {
        this.userDiversity = userDiversity;
    }

    public UserDocuments getUserDocuments() {
        return userDocuments;
    }

    public void setUserDocuments(UserDocuments userDocuments) {
        this.userDocuments = userDocuments;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
