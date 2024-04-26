package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;

import java.util.Date;  // Import Date class

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cus_id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String phoneNo;
    private String hearAbout;
    @Temporal(TemporalType.DATE)
    private Date registration_date;

    public Customer(Long cus_id, String firstname, String lastname, String email, String address, String phoneNo, String hearAbout, Date registration_date) {
        this.cus_id = cus_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNo = phoneNo;
        this.hearAbout = hearAbout;
        this.registration_date = registration_date;
    }

    public Customer() {

    }

    public Long getCus_id() {
        return cus_id;
    }

    public void setCus_id(Long cus_id) {
        this.cus_id = cus_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getHearAbout() {
        return hearAbout;
    }

    public void setHearAbout(String hearAbout) {
        this.hearAbout = hearAbout;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}