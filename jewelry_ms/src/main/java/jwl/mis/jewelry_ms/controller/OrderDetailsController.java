package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Order_details;
import jwl.mis.jewelry_ms.model.Reservation;
import jwl.mis.jewelry_ms.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @PostMapping("/postorders")
    Order_details newOrder(@RequestBody Order_details newOrder){
        return orderDetailsRepository.save(newOrder);
    }



}
