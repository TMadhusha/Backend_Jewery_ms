package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Inventory inventory;
    @ManyToOne
    @JoinColumn(name = "sup_id")
    private Supplier supplier;
    private String description;
    private double unitPrice;
    private int quantity;
    private double tax;
    private double cost;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] receipt;

}
