package jwl.mis.jewelry_ms.controller;

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

    @PostMapping("/payment-main")
    Payment newPayment(@RequestBody Payment newPayment){

        return paymentRepository.save(newPayment);
    }


    @DeleteMapping("/delete/{paymentid}")
    String deletesup(@PathVariable Long paymentid){
        if(!paymentRepository.existsById(paymentid)){
//            throw new UserNotFoundException(sup_id);
            return "User Not Found";
        }else paymentRepository.deleteById(paymentid);
        return paymentid+" "+" was deleted";
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
    @GetMapping("/update-liability/{paymentid}") //for lodesupplier
    Payment getPaymentrById(@PathVariable("paymentid") Long paymentid){
        return paymentRepository.findById(paymentid)
                .orElseThrow(()->new UserNotFoundException(paymentid));}



    //update liability
    @PutMapping("/liability/{paymentid}")
    public Payment updateliability(@RequestBody Payment newPayment, @PathVariable Long paymentid) {
        return paymentRepository.findById(paymentid)
                .map(payment -> {
                    payment.setPaid(newPayment.getPaid());
                    payment.setComment(newPayment.getComment()); // Set comment on payment instance
                    return paymentRepository.save(payment);
                })
                .orElseThrow(() -> new UserNotFoundException(paymentid));
    }

   // update payable
    @PutMapping("/payable/{paymentid}")
    public Payment updatepayable(@RequestBody Payment newPayment, @PathVariable Long paymentid) {
        return paymentRepository.findById(paymentid)
                .map(payment -> {
                    payment.setTotal(newPayment.getTotal());
                    payment.setComment(newPayment.getComment()); // Set comment on payment instance
                    return paymentRepository.save(payment);
                })
                .orElseThrow(() -> new UserNotFoundException(paymentid));
    }

}
