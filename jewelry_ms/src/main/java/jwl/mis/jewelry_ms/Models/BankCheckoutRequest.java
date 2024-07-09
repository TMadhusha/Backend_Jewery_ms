package jwl.mis.jewelry_ms.Models;

import lombok.Data;

@Data
public class BankCheckoutRequest {
    private String username;
    private String cardnumber;
    private String cvv;
    private String month;
    private String year;

}
