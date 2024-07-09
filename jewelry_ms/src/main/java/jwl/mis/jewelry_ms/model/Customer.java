package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
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
}
