package campolina.hrgroup.hrapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "user_documents")
public class UserDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_docs_id")
    private Long userDocsId;

    @NotBlank
    @Column(name = "resume_location")
    private String resumeLocation;

    @Column(name = "cover_letter_location")
    private String coverLetterLocation;

    @Column(name = "link")
    private String link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_applicant_id")
    private Applicant applicant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee_id")
    private Employee employee;

    public String getCoverLetterLocation() {
        return coverLetterLocation;
    }

    public String getResumeLocation() {
        return resumeLocation;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getLink() {
        return link;
    }

    public Long getUserDocsId() {
        return userDocsId;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setCoverLetterLocation(String coverLetterLocation) {
        this.coverLetterLocation = coverLetterLocation;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setResumeLocation(String resumeLocation) {
        this.resumeLocation = resumeLocation;
    }

    public void setUserDocsId(Long userDocsId) {
        this.userDocsId = userDocsId;
    }
}
