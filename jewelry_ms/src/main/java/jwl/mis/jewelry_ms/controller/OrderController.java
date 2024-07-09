package jwl.mis.jewelry_ms.controller;


import jwl.mis.jewelry_ms.model.Customer;
import jwl.mis.jewelry_ms.model.Order;
import jwl.mis.jewelry_ms.model.OrderItem;
import jwl.mis.jewelry_ms.repository.OrderItemRepository;
import jwl.mis.jewelry_ms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @GetMapping("/getorder")
    List<Order> getAllOrder(){
        return orderRepository.findAll();
    }


    @PutMapping("/orders/{orderId}")
    public Order updateOrderStatus(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setOrderStatus(updatedOrder.getOrderStatus());
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found with id " + orderId);
        }
    }


    @GetMapping("/orders/customer/{orderId}")
    public Customer getCustomerDetailsByOrderId(@PathVariable Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            return order.getCustomer();
        } else {
            throw new RuntimeException("Order not found with id " + orderId);
        }
    }

    @GetMapping("/{orderId}/items")
    public List<OrderItem> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return orderItemRepository.findByOrderOrderId(orderId);
    }






}
