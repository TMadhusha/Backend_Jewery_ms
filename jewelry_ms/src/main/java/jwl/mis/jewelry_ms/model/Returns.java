package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Returns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long return_id;
    private String name;
    private String contact;
    private String purchaseDate;
    private String returnReason;
    private String comments;
    private String itemCondition;
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private SalesAndRevenues salesAndRevenues;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Inventory inventory;

    // Default constructor
    public Returns() {
    }

    // Parameterized constructor


    public Returns(long return_id, String name, String contact, String purchaseDate, String returnReason, String comments, String itemCondition, String returnDate, Customer customer, SalesAndRevenues salesAndRevenues, Inventory inventory) {
        this.return_id = return_id;
        this.name = name;
        this.contact = contact;
        this.purchaseDate = purchaseDate;
        this.returnReason = returnReason;
        this.comments = comments;
        this.itemCondition = itemCondition;
        this.returnDate = returnDate;
        this.customer = customer;
        this.salesAndRevenues = salesAndRevenues;
        this.inventory = inventory;
    }
}