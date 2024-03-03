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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @NotBlank
    @Column(name = "country")
    private String country;

    @NotBlank
    @Column(name = "state")
    private String state;

    @NotBlank
    @Column(name = "postcode")
    private String postcode;

    @NotBlank
    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "address_line3")
    private String addressLine3;

    @NotBlank
    @Column(name = "city")
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_applicant_id")
    private Applicant applicant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee_id")
    private Employee employee;

    public Long getAddressId() {
        return addressId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    // public Applicant getApplicant() {
    //     return applicant;
    // }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    // public Employee getEmployee() {
    //     return employee;
    // }

    public String getPostcode() {
        return postcode;
    }

    public String getState() {
        return state;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setState(String state) {
        this.state = state;
    }
}
