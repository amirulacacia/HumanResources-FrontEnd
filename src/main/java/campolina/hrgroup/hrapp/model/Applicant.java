package campolina.hrgroup.hrapp.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private long applicantId;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @ManyToMany
    @JoinTable(
        name = "applicant_status",
        joinColumns = @JoinColumn(name = "fk_applicant_id"),
        inverseJoinColumns = @JoinColumn(name = "fk_job_post_id")
    )
    private Set<JobPosting> jobStatus = new HashSet<>();

    @OneToOne(mappedBy = "applicant")
    private UserInfo userInfo;

    @OneToOne(mappedBy = "applicant")
    private UserDiversity userDiversity;

    @OneToOne(mappedBy = "applicant")
    private UserDocuments userDocuments;

    @OneToOne(mappedBy = "applicant")
    private AdditionalInfo additionalInfo;

    @OneToOne(mappedBy = "applicant")
    private Address address;

    @OneToOne(mappedBy = "applicant")
    private Interview interview;

    @OneToMany
    @JoinColumn(name = "fk_applicant_id", referencedColumnName = "applicant_id")
    private List<Skill> skills;

    @OneToMany
    @JoinColumn(name = "fk_applicant_id", referencedColumnName = "applicant_id")
    private List<Certificate> certificates;

    @OneToMany
    @JoinColumn(name = "fk_applicant_id", referencedColumnName = "applicant_id")
    private List<Education> educations;

    @OneToMany
    @JoinColumn(name = "fk_applicant_id", referencedColumnName = "applicant_id")
    private List<Experience> experiences;

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<JobPosting> getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Set<JobPosting> jobStatus) {
        this.jobStatus = jobStatus;
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

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
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
