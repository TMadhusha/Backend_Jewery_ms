package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.Models.AdminLoginRequest;
import jwl.mis.jewelry_ms.Models.BankCheckoutRequest;
import jwl.mis.jewelry_ms.model.Admin;
import jwl.mis.jewelry_ms.model.Bank;

import jwl.mis.jewelry_ms.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    @PostMapping("/bank-save")
    Bank newBank(@RequestBody Bank newBank) {
        System.out.println(newBank);
        return bankRepository.save(newBank);
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody BankCheckoutRequest checkoutRequest) {
        String username = checkoutRequest.getUsername();
        String cvv = checkoutRequest.getCvv();
        String cardnumber = checkoutRequest.getCardnumber();
        String month= checkoutRequest.getMonth();
        String year= checkoutRequest.getYear();

        // Find the admin by username
        Bank bank = bankRepository.findBankByUsername(username);
//balance seyyonum
        if (bank == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid AccountNumber or Backnumber or Cardnumber");
        } else {
            if (bank.getUsername().equals(username)&&bank.getCvv().equals(cvv)&&bank.getCardnumber().equals(cardnumber)&&bank.getMonth().equals(month)&&bank.getYear().equals(year)) {
                //return ResponseEntity.ok("Login successful");
                        return ResponseEntity.ok("Details Approved");
                        //want to add the Order table update code 

            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        }
    }

}
