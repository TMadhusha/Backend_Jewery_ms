package jwl.mis.jewelry_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Data
public class Supplier {

    @Id
    @GeneratedValue
    private Long sup_id;

    private String supname;
    private String address;

    @Column(unique = true) // Ensure idNumber is unique
    private String idNumber;

    private String itemName;
    private String phonenumber;
    private String email;
}
