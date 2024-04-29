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
    private Long bankid;
    private String username;
    private String cardnumber;
    private String cvv;
    private String month;
    private String year;
    private Integer balance;
    private String accountnumber;


}
