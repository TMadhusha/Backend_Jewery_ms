package jwl.mis.jewelry_ms.controller;


import jwl.mis.jewelry_ms.model.Customer;
import jwl.mis.jewelry_ms.model.Order;
import jwl.mis.jewelry_ms.model.Returns;
import jwl.mis.jewelry_ms.repository.CustomerRepository;
import jwl.mis.jewelry_ms.repository.OrderRepository;
import jwl.mis.jewelry_ms.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin( "http://localhost:3000")
public class ReturnController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReturnRepository returnRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/order/{orderId}")
    public Optional<Order> getOrderDetails(@PathVariable Long orderId) {
        return Optional.ofNullable(orderRepository.findByOrderId(orderId));
    }

    @PostMapping("/postreturns")
    public Returns createReturns(@RequestBody Returns returns) {
        if (returns.getCustomer() == null) {
            throw new RuntimeException("Customer is not provided in the request");
        }
        if (returns.getOrder() == null) {
            throw new RuntimeException("Order is not provided in the request");
        }

        Optional<Customer> customerOpt = customerRepository.findById(returns.getCustomer().getCus_id());
        Optional<Order> orderOpt = orderRepository.findById(returns.getOrder().getOrderId());

        if (customerOpt.isPresent() && orderOpt.isPresent()) {
            returns.setCustomer(customerOpt.get());
            returns.setOrder(orderOpt.get());
            return returnRepository.save(returns);
        } else {
            throw new RuntimeException("Customer or Order not found");
        }
    }
}
