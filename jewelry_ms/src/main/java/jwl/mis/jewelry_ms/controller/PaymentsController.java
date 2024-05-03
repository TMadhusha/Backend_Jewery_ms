package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Order_details;
import jwl.mis.jewelry_ms.model.Payments;
import jwl.mis.jewelry_ms.repository.OrderDetailsRepository;
import jwl.mis.jewelry_ms.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class PaymentsController {
    @Autowired
    private PaymentsRepository paymentsRepository;

    @PostMapping("/postpayments")
    Payments newPayment(@RequestBody Payments newPayment){
        return paymentsRepository.save(newPayment);
    }

    @GetMapping("/getpayments")
    List<Payments> getAllPayments(){
        return paymentsRepository.findAll();
    }
}
