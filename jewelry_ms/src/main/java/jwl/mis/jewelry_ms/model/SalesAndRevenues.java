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
    private Long qty;
    private double unitPrice;
    private double totalSalesAmount;
    private double paidAmount;
    private double balance;
    private String status;

    @ManyToOne
    @JoinColumn(name = "cus_id") // Foreign key column
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Inventory inventory;

    // Default constructor
    public SalesAndRevenues() {
    }

    // Parameterized constructor


    public SalesAndRevenues(Long transactionId, LocalDate date, Long qty, double unitPrice, double totalSalesAmount, double paidAmount, double balance, String status, Customer customer, Inventory inventory) {
        this.transactionId = transactionId;
        this.date = date;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalSalesAmount = totalSalesAmount;
        this.paidAmount = paidAmount;
        this.balance = balance;
        this.status = status;
        this.customer = customer;
        this.inventory = inventory;
    }
}