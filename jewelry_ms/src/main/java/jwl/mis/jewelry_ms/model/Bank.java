package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bannkid;
    private String username;
    private String accountnumber;
    private String cardnumber;
    private String backnumber;
    private Integer balance;


}
