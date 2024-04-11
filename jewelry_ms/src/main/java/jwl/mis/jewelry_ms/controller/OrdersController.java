package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Customer;
import jwl.mis.jewelry_ms.model.Orders;
import jwl.mis.jewelry_ms.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class OrdersController {

    @Autowired
    private OrdersRepository orderRepository;

    @PostMapping("/postorders")
    Orders newOrder(@RequestBody Orders newOrder){
        return orderRepository.save(newOrder);
    }

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
}
