package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
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
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Inventory inventory;
    private Long qty;
    private double unitPrice;
    private double totalSalesAmount;
    private double paidAmount;
    private double balance;
    private String status;
}
