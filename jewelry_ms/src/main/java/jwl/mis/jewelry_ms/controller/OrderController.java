package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Order;
import jwl.mis.jewelry_ms.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save-order")
    public Order newOrder(@RequestBody Order newOrder) {
        logger.info("Received Order: {}", newOrder);
        return orderRepository.save(newOrder);
    }
}
