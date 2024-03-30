package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Customer;
import jwl.mis.jewelry_ms.repository.CustomerRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer")
    Customer newCustomer(@RequestBody Customer newCustomer){
        return customerRepository.save(newCustomer);
    }
    @GetMapping("/getcustomer")
    List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
}
