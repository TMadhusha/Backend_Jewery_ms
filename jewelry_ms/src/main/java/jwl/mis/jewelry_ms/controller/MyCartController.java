package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.MyCart;
import jwl.mis.jewelry_ms.repository.MyCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class MyCartController {

    @Autowired
    private MyCartRepository myCartRepository;

    @GetMapping("/user/{username}")
    public ResponseEntity<List<MyCart>> getMyCartByUsername(@PathVariable String username) {
        try {
            List<MyCart> myCartList = myCartRepository.findByUsername(username);
            return new ResponseEntity<>(myCartList, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
