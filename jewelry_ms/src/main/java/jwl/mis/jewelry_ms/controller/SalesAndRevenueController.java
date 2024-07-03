package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.SalesAndRevenues;
import jwl.mis.jewelry_ms.repository.SalesAndRevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SalesAndRevenueController {
    @Autowired
    private SalesAndRevenueRepository salesAndRevenueRepository;

    @PostMapping("/salesAndRevenuesP")
    SalesAndRevenues newSalesAndRevenue(@RequestBody SalesAndRevenues newSalesAndRevenue){
        return salesAndRevenueRepository.save(newSalesAndRevenue);
    }

    @GetMapping("/salesAndRevenuesG")
    List<SalesAndRevenues> getAllSalesAndRevenues(){
        return salesAndRevenueRepository.findAll();
    }

}
