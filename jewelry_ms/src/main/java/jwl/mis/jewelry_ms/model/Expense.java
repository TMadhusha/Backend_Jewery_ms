package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    private double amount;
    private String type;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] receipt;
}
