package jwl.mis.jewelry_ms.Models;

import lombok.Data;

@Data
public class BankCheckoutRequest {
    private String cardnumber;
    private String accountnumber;
    private String backnumber;

}
