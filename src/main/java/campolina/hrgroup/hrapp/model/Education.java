package campolina.hrgroup.hrapp.model;

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
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Long educationId;

    @NotBlank
    @Column(name = "education_level")
    private String educationLevel;

    @NotBlank
    @Column(name = "major")
    private String major;

    @NotBlank
    @Column(name = "school")
    private String school;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private String startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private String endDate;

    @Column(name = "cgpa")
    private String cgpa;

    @Column(name = "graduation_year")
    private String graduationYear;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Long getEducationId() {
        return educationId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public String getCgpa() {
        return cgpa;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public String getMajor() {
        return major;
    }

    public String getSchool() {
        return school;
    }

    public String getStartDate() {
        return startDate;
    }
    
    public void setEducationId(Long educationId) {
        this.educationId = educationId;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
