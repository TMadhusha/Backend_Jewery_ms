package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.SupplierNotFoundException;
import jwl.mis.jewelry_ms.exception.UserNotFoundException;
import jwl.mis.jewelry_ms.model.Payment;
import jwl.mis.jewelry_ms.model.Supplier;
import jwl.mis.jewelry_ms.repository.PaymentRepository;
import jwl.mis.jewelry_ms.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @DeleteMapping("/delete/{paymentid}")
    public String deletesup(@PathVariable Long paymentid) {
        return paymentRepository.findById(paymentid)
                .map(payment -> {
                    Long balance = payment.getBalance();
                    if (balance == 0) {
                        paymentRepository.deleteById(paymentid);
                        return paymentid + " was deleted";
                    } else if (balance < 0) {
                        return "There are some payments you want to get from the company";
                    } else {
                        return "Supplier has a payment so cannot delete it";
                    }
                })
                .orElse("User Not Found");
    }



    @GetMapping("/get-payment")
    List<Payment> getAllSupplier(){
        return paymentRepository.findAll();
    }

    //load payment to payable
    @GetMapping("/load-payable/{paymentid}") //for lodesupplier
    Payment gettotalById(@PathVariable("paymentid") Long paymentid){
        return paymentRepository.findById(paymentid)
                .orElseThrow(()->new UserNotFoundException(paymentid));}

//load payment to liability
@GetMapping("/update-liability/{paymentid}") // for loading supplier
public Payment getPaymentrById(@PathVariable("paymentid") Long paymentid) {
    return paymentRepository.findById(paymentid)
            .orElseThrow(() -> new UserNotFoundException(paymentid));
}





    //update liability
//    @PutMapping("/liability/{paymentid}")
//    public Payment updateliability(@RequestBody Payment newPayment, @PathVariable Long paymentid) {
//        return paymentRepository.findById(paymentid)
//                .map(payment -> {
//                    payment.setPaid(newPayment.getPaid());
//                    payment.setComment(newPayment.getComment()); // Set comment on payment instance
//                    Long total = newPayment.getTotal();
//                    Long paid = newPayment.getPaid();
//                    Long balance = total - paid;
//                    payment.setBalance((long) balance);
//                    return paymentRepository.save(payment);
//                })
//                .orElseThrow(() -> new UserNotFoundException(paymentid));
//
//    }
    @PutMapping("/liability/{paymentid}")
    public Payment updateliability(@RequestBody Payment newPayment, @PathVariable Long paymentid) {
        return paymentRepository.findById(paymentid)
                .map(payment -> {
                    payment.setPaid(newPayment.getPaid());
                    payment.setComment(newPayment.getComment()); // Set comment on payment instance
                    Long total = newPayment.getTotal();
                    Long paid = newPayment.getPaid();
                    Long balance = total - paid;
                    payment.setBalance((long) balance);
                    return paymentRepository.save(payment);
                })
                .orElseThrow(() -> new UserNotFoundException(paymentid));

    }


    //1st add payment

//    @PostMapping("/payment-main")
//    Payment newPayment(@RequestBody Payment newPayment){
//
//        return paymentRepository.save(newPayment);
//    }

    @PostMapping("/payment-main")
    public Payment newPayment(@RequestBody Payment newPayment) {
        Long supId = newPayment.getSup_id();

        // Check if supId already exists in the Payment entity
        Iterable<Payment> payments = paymentRepository.findAll();
        for (Payment payment : payments) {
            if (payment.getSup_id().equals(supId)) {
                throw new SupplierNotFoundException("Sup Id " + supId + " already exists in the payment table.");
            }
        }

        // Check if supId already exists in the Supplier entity
        boolean supIdExistsInSupplier = supplierRepository.existsById(supId);
        if (!supIdExistsInSupplier) {
            throw new UserNotFoundException(supId);
        }

        // Save the new payment
        Payment savedPayment = paymentRepository.save(newPayment);

        // Calculate balance
        Long total = savedPayment.getTotal();
        Long paid = savedPayment.getPaid();
        Long balance = total - paid;

        // Update balance in the saved payment
        savedPayment.setBalance(balance);

        // Save the updated payment with the calculated balance
        return paymentRepository.save(savedPayment);
    }

   // update payable
//    @PutMapping("/payable/{paymentid}")
//    public Payment updatepayable(@RequestBody Payment newPayment, @PathVariable Long paymentid) {
//        return paymentRepository.findById(paymentid)
//                .map(payment -> {
//                    payment.setTotal(newPayment.getTotal());
//                    payment.setPaid(newPayment.getPaid());
//                    payment.setComment(newPayment.getComment());
//
//                    // Calculate balance
//                    Long total = newPayment.getTotal();
//                    Long paid = newPayment.getPaid();
//                    Long balance = total - paid;
//                    payment.setBalance((long) balance);
//
//                    return paymentRepository.save(payment);
//                })
//                .orElseThrow(() -> new UserNotFoundException(paymentid));
//    }
//
//}

    @PutMapping("/payable/{paymentid}")
    public Payment updatepayable(@RequestBody Payment newPayment, @PathVariable Long paymentid) {
        return paymentRepository.findById(paymentid)
                .map(payment -> {
                    // Calculate new total and paid amounts
                    Long updatedTotal = payment.getTotal() + newPayment.getTotal();
                    Long paid=payment.getPaid();

                    // Update payment entity
                    payment.setTotal(updatedTotal);

                    payment.setComment(newPayment.getComment());

                    // Calculate balance
                    Long balance = updatedTotal - paid;
                    payment.setBalance(balance);

                    return paymentRepository.save(payment);
                })
                .orElseThrow(() -> new UserNotFoundException(paymentid));
    }}
