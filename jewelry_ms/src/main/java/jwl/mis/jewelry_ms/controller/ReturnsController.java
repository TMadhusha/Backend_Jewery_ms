package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Returns;
import jwl.mis.jewelry_ms.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ReturnsController {
    @Autowired
    private ReturnRepository returnRepository;

    @PostMapping("/postreturn")
    Returns newReturn(@RequestBody Returns newReturn){
        return returnRepository.save(newReturn);
    }

    @GetMapping("/getreturn")
    List<Returns> getAllReturn(){
        return returnRepository.findAll();
    }

}
