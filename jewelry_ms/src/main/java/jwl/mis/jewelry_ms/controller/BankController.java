package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.Models.AdminLoginRequest;
import jwl.mis.jewelry_ms.Models.BankCheckoutRequest;
import jwl.mis.jewelry_ms.model.Admin;
import jwl.mis.jewelry_ms.model.Bank;

import jwl.mis.jewelry_ms.model.BankSession;
import jwl.mis.jewelry_ms.repository.BankRepository;
import jwl.mis.jewelry_ms.repository.BankSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BankController {

    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private BankSessionRepository bankSessionRepository;

    @PostMapping("/bank-save")
    Bank newBank(@RequestBody Bank newBank) {
        System.out.println(newBank);
        return bankRepository.save(newBank);
    }

//    @PostMapping("/checkout")
//    public ResponseEntity<String> checkout(@RequestBody BankCheckoutRequest checkoutRequest) {
//        String username = checkoutRequest.getUsername();
//        String cvv = checkoutRequest.getCvv();
//        String cardnumber = checkoutRequest.getCardnumber();
//        String month= checkoutRequest.getMonth();
//        String year= checkoutRequest.getYear();
//
//        // Find the admin by username
//        Bank bank = bankRepository.findBankByUsername(username);
////balance seyyonum
//        if (bank == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid AccountNumber or Backnumber or Cardnumber");
//        } else {
//            if (bank.getUsername().equals(username)&&bank.getCvv().equals(cvv)&&bank.getCardnumber().equals(cardnumber)&&bank.getMonth().equals(month)&&bank.getYear().equals(year)) {
//                //return ResponseEntity.ok("Login successful");
//                        return ResponseEntity.ok("Details Approved");
//                        //want to add the Order table update code
//
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//            }
//        }
//    }


    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody BankCheckoutRequest checkoutRequest) {
        String username = checkoutRequest.getUsername();
        String cvv = checkoutRequest.getCvv();
        String cardnumber = checkoutRequest.getCardnumber();
        String month= checkoutRequest.getMonth();
        String year= checkoutRequest.getYear();

        // Find the bank by username
        Bank bank = bankRepository.findBankByUsername(username);

        if (bank == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid AccountNumber or Backnumber or Cardnumber");
        } else {
            if (bank.getUsername().equals(username) &&
                    bank.getCvv().equals(cvv) &&
                    bank.getCardnumber().equals(cardnumber) &&
                    bank.getMonth().equals(month) &&
                    bank.getYear().equals(year)) {

                // Create and save BankSession
                BankSession bankSession = new BankSession();
                bankSession.setAccountnumber(bank.getAccountNumber());
                bankSession.setBalance(bank.getBalance());
                bankSessionRepository.save(bankSession);

                return ResponseEntity.ok("Details Approved");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        }
    }

}
