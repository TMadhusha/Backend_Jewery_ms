package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class RemoteCustomers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cus_id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String phoneNo;
    private String username;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date registration_date;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] dp;

    public RemoteCustomers(Long cus_id, String firstname, String lastname, String email, String address, String phoneNo, String username, String password, Date registration_date, byte[] dp) {
        this.cus_id = cus_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNo = phoneNo;
        this.username = username;
        this.password = password;
        this.registration_date = registration_date;
        this.dp = dp;
    }

    public RemoteCustomers() {

    }
}
