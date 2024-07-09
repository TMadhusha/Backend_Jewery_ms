package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.CartNotFoundException;
import jwl.mis.jewelry_ms.model.Cart;
import jwl.mis.jewelry_ms.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/addCart")
    Cart newCart(@RequestParam ("image") MultipartFile image,
                 @RequestParam ("itemName") String itemName,
                 @RequestParam ("username") String username,
                 @RequestParam ("type") String type,
                 @RequestParam ("description") String description,
                 @RequestParam ("sellingPrice") double sellingPrice,
                 @RequestParam ("quantity") int quantity,
                 @RequestParam ("totalPrice") double totalPrice){

        try{
            Cart newCart=new Cart();
            newCart.setImage(image.getBytes());
            newCart.setItemName(itemName);
            newCart.setUsername(username);
            newCart.setType(type);
            newCart.setDescription(description);
            newCart.setSellingPrice(sellingPrice);
            newCart.setQuantity(quantity);
            newCart.setTotalPrice(totalPrice);
            return cartRepository.save(newCart);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getCart")
    List<Cart> getAllCart(){
        return cartRepository.findAll();
    }

//    @GetMapping("/getCartById/{username}")
//    List<Cart> getByUsername(@PathVariable String username) {
//        List<Cart> carts = cartRepository.findByUsername(username);
//    List<Cart> getAllCart(){
//        return cartRepository.findAll();
//    }
//
//    @GetMapping("/getCartById/{username}")
//    List<Cart> getByUsername(@PathVariable String username) {
//       // List<Cart> carts = cartRepository.findByUsername(username);
//        if (carts.isEmpty()) {
//            throw new CartNotFoundException(username);
//        }
//        return carts;
//    }

    @GetMapping("/getCartById/{username}")
    public ResponseEntity<List<Cart>> getByUsername(@PathVariable String username) {
        try {
            List<Cart> carts = cartRepository.findByUsername(username);
            return ResponseEntity.ok(carts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/putCart/{Id}")
    Cart updateCart(@RequestBody Cart newCart, @PathVariable Long Id){
        try{
            //Fetch existing cart
            Cart existingCart=cartRepository.findById(Long.valueOf(Id))
                    .orElseThrow(() -> new CartNotFoundException(Id));

            //update Cart
            existingCart.setQuantity(newCart.getQuantity());
            existingCart.setTotalPrice(newCart.getTotalPrice());

            return cartRepository.save(existingCart);
        }catch (Exception e){
            throw new RuntimeException("Failed to update the cart "+Id, e);
        }
    }

    @DeleteMapping("/deleteCart/{Id}")
    String deleteCart(@PathVariable Long Id){
        if(!cartRepository.existsById(Id)){
            throw new CartNotFoundException(Id);
        }
        cartRepository.deleteById(Id);
        return "Cart item with id "+ Id +" has been deleted sucessfully";
    }


}
