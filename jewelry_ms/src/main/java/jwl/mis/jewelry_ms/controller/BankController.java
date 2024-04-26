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
    Bank newBank(@RequestBody Bank newBank){
        System.out.println(newBank);
        return bankRepository.save(newBank);
    }

    @PutMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody BankCheckoutRequest checkoutRequest) {
        String accountnumber = checkoutRequest.getAccountnumber();
        String backnumber = checkoutRequest.getBacknumber();
        String cardnumber = checkoutRequest.getCardnumber();

        // Find the admin by username
        Bank bank = bankRepository.findBankByAccountnumber(accountnumber);
//balance seyyonum
//        if (bank == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid AccountNumber or Backnumber or Cardnumber");
//        } else {
//            if (bank.getAccountnumber().equals(accountnumber)) {
//                return ResponseEntity.ok("Login successful");
//                if (bank.getBacknumber().equals(backnumber)){
//                    if (bank.getCardnumber().equals(cardnumber)){
//                        return ResponseEntity.ok("Details Approved");
//                    }
//                }
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//            }
//        }
//    }
//
        return null;
    }}
