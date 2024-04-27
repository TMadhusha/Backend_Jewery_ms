package jwl.mis.jewelry_ms.Models;

import lombok.Data;

@Data
public class BankCheckoutRequest {
    private String username;
    private String cardnumber;
    private String backnumber;

}
