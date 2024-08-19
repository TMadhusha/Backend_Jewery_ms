package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Customer;
import jwl.mis.jewelry_ms.model.Returns;
import jwl.mis.jewelry_ms.model.SalesAndRevenues;
import jwl.mis.jewelry_ms.repository.CustomerRepository;
import jwl.mis.jewelry_ms.repository.ReturnRepository;
import jwl.mis.jewelry_ms.repository.SalesAndRevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReturnController {

    @Autowired
    private SalesAndRevenueRepository salesAndRevenueRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReturnRepository returnRepository;

    @GetMapping("/sales/{transactionId}")
    public ResponseEntity<?> getSalesDetails(@PathVariable Long transactionId) {
        Optional<SalesAndRevenues> salesDetailsOptional = salesAndRevenueRepository.findByTransactionIdWithCustomer(transactionId);
        if (salesDetailsOptional.isPresent()) {
            return ResponseEntity.ok(salesDetailsOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/postreturns")
    public ResponseEntity<String> submitReturnRequest(@RequestBody Returns returnRequest) {
        try {
            // Retrieve customer and salesAndRevenues details from their respective repositories
            Optional<Customer> customerOptional = customerRepository.findById(returnRequest.getCustomer().getCus_id());
            Optional<SalesAndRevenues> salesAndRevenuesOptional = salesAndRevenueRepository.findById(returnRequest.getSalesAndRevenues().getTransactionId());

            if (!customerOptional.isPresent() || !salesAndRevenuesOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Invalid customer or sales transaction ID");
            }

            // Set the retrieved entities in the return request
            returnRequest.setCustomer(customerOptional.get());
            returnRequest.setSalesAndRevenues(salesAndRevenuesOptional.get());

            // Save the return request
            returnRepository.save(returnRequest);

            return ResponseEntity.ok("Return request submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting return request: " + e.getMessage());
        }
    }
}