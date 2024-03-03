package campolina.hrgroup.hrapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long skillId;

    @NotBlank
    @Column(name = "skill")
    private String skill;

    @ManyToOne
    @JoinColumn(name = "fk_applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "fk_employee_id")
    private Employee employee;

    public Applicant getApplicant() {
        return applicant;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getSkill() {
        return skill;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }
}
