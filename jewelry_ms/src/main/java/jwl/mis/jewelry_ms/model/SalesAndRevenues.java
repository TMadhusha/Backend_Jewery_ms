package jwl.mis.jewelry_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
public class SalesAndRevenues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Long cusId;
    private String itemId;
    private LocalDate date;
    private Long qty;
    private double unitPrice;
    private double totalSalesAmount;
    private double paidAmount;
    private double balance;
    private String status;
}
