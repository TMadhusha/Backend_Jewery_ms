package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.CustomerNotFoundException;
import jwl.mis.jewelry_ms.model.Customer;
import jwl.mis.jewelry_ms.model.Order_details;
import jwl.mis.jewelry_ms.model.Reservation;
import jwl.mis.jewelry_ms.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @PostMapping("/postorders")
    Order_details newOrder(@RequestBody Order_details newOrder){
        return orderDetailsRepository.save(newOrder);
    }

    @GetMapping("/getorders")
    List<Order_details> getAllOrders(){
        return orderDetailsRepository.findAll();
    }



}
