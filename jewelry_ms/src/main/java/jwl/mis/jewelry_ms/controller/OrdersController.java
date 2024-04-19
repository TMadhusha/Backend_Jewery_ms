package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.OrderNotFoundException;
import jwl.mis.jewelry_ms.model.Orders;
import jwl.mis.jewelry_ms.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class OrdersController {

    @Autowired
    private OrdersRepository orderRepository;

    @PostMapping("/postorders")
    public ResponseEntity<Orders> newOrder(@RequestBody Orders newOrder){
        Orders savedOrder = orderRepository.save(newOrder);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/orders/{order_id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long order_id){
        Orders order = orderRepository.findById(order_id)
                .orElseThrow(() -> new OrderNotFoundException(order_id));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
