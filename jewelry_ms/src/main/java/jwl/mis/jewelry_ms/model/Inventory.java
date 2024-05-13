package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inventory {
    @Id
    private String item_id;
    private String itemName;
    private String type;
    private Double actualPrice;
    private String description;
    private Double sellingPrice;
    private int availableStock;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;


}