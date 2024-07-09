package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentid;
    private Long sup_id;
    private Long total;
    private Long paid;
    private Long balance;
    private String comment;


}
