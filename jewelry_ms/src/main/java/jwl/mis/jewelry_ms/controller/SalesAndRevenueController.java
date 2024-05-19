package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.SalesAndRevenues;
import jwl.mis.jewelry_ms.repository.CustomerRepository;
import jwl.mis.jewelry_ms.repository.InventoryRepository;
import jwl.mis.jewelry_ms.repository.SalaryRepository;
import jwl.mis.jewelry_ms.repository.SalesAndRevenuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SalesAndRevenueController {
    @Autowired
    private SalesAndRevenuesRepository salesAndRevenuesRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("/salesAndRevenuesP")
    SalesAndRevenues newSalesAndRevenues(@RequestBody SalesAndRevenues newSalesAndRevenues){
        return salesAndRevenuesRepository.save(newSalesAndRevenues);
    }

    @GetMapping("/salesAndRevenuesG")
    List<SalesAndRevenues> getAllSalesAndRevenues(){
        return salesAndRevenuesRepository.findAll();
    }


}
