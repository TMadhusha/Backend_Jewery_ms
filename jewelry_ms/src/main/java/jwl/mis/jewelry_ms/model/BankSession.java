package jwl.mis.jewelry_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class BankSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bankSessionid;
    private Integer balance;
    private String accountnumber;


}
