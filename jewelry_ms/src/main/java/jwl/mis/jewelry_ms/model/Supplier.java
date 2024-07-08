package jwl.mis.jewelry_ms.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue
    private Long sup_id;
    private String supname;
    private String address;
    private String idNumber;
    private String itemName;
    private String phonenumber;
    private String email;


}



