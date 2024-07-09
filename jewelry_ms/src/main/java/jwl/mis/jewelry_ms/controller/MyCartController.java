package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.MyCart;
import jwl.mis.jewelry_ms.repository.MyCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class MyCartController {
    @Autowired
    private MyCartRepo myCartRepo;

    @PostMapping("/mycartAdd")
    MyCart newMycart(@RequestBody MyCart newMycart){
        return myCartRepo.save(newMycart);
    }
}
