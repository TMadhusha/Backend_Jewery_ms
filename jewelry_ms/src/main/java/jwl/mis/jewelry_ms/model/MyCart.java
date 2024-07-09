package jwl.mis.jewelry_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MyCart {
    @Id

    private Long myCartId;
    private String username;
    private String itemName;
    private int quantity;
    private double totalPrice;
}
