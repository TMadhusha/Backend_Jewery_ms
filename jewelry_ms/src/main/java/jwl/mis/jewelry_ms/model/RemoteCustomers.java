package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] dp;


}
