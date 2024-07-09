package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    private String itemName;

    private String username;
    private String type;
    private String description;
    private double sellingPrice;
    private int quantity;
    private double totalPrice;


}
