//package jwl.mis.jewelry_ms.controller;
//
//import jwl.mis.jewelry_ms.model.Bank;
//import jwl.mis.jewelry_ms.model.Order;
//import jwl.mis.jewelry_ms.repository.OrderRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class OrderController {
//
//
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @PostMapping("/save-order")
//    Order newOrder(@RequestBody Order newOrder) {
//        System.out.println(newOrder);
//        return orderRepository.save(newOrder);
//    }
//}

package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Cart;
import jwl.mis.jewelry_ms.model.Order;
import jwl.mis.jewelry_ms.model.RemoteCustomers;
import jwl.mis.jewelry_ms.repository.CartRepository;
import jwl.mis.jewelry_ms.repository.OrderRepository;
import jwl.mis.jewelry_ms.repository.RemoteCustomerRepository;
import jwl.mis.jewelry_ms.repository.RemoteCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RemoteCustomerRepository remoteCustomerRepository;

        @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save-order")
    Order newOrder(@RequestBody Order newOrder) {
        System.out.println(newOrder);
        return orderRepository.save(newOrder);
    }

    @GetMapping("/cart-summary/{username}")
    public CartSummary getCartSummary(@PathVariable String username) {
        RemoteCustomers customer = remoteCustomerRepository.findByUsername(username);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        Long cusId = customer.getCus_id();
        List<Cart> cartItems = cartRepository.findByUsername(username);

        double totalPrice = cartItems.stream().mapToDouble(Cart::getTotalPrice).sum();

        return new CartSummary(cusId, totalPrice);
    }

    static class CartSummary {
        private Long cusId;
        private double totalPrice;

        public CartSummary(Long cusId, double totalPrice) {
            this.cusId = cusId;
            this.totalPrice = totalPrice;
        }

        public Long getCusId() {
            return cusId;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }
}

