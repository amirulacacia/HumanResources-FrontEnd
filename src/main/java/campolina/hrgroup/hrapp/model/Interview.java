package campolina.hrgroup.hrapp.model;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

@Entity
@Table(name = "interview")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private Long interviewId;

    @Column(nullable = false, name = "appointment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;

    @Column(nullable = false, name = "appointment_time")
    private LocalTime appointmentTime;

    @NotBlank
    private String platform;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToMany(mappedBy = "assignInterview")
    private Set<Employee> assignEmployees = new HashSet<>();

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }
    
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Long getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Long interviewId) {
        this.interviewId = interviewId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Set<Employee> getAssignEmployees() {
        return assignEmployees;
    }

    public void setAssignEmployees(Set<Employee> assignEmployees) {
        this.assignEmployees = assignEmployees;
    }
}
