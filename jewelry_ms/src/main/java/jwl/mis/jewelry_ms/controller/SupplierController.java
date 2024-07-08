package jwl.mis.jewelry_ms.controller;



import jwl.mis.jewelry_ms.exception.EmployeeNotFoundException;
import jwl.mis.jewelry_ms.exception.UserNotFoundException;
import jwl.mis.jewelry_ms.model.Employee;
import jwl.mis.jewelry_ms.model.Payment;
import jwl.mis.jewelry_ms.model.Supplier;
import jwl.mis.jewelry_ms.repository.PaymentRepository;
import jwl.mis.jewelry_ms.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/save-supplier")
    Supplier newSupplier(@RequestBody Supplier newSupplier){
        System.out.println(newSupplier);
        return supplierRepository.save(newSupplier);
    }
    @GetMapping("/get-supplier")
    List<Supplier>getAllSupplier(){
        return supplierRepository.findAll();
    }

//    @GetMapping("/PSupplier/{sup_id}")
//    Supplier getSuppliyerByName(@PathVariable Long sup_id) {
//        return supplierRepository.findById(sup_id)
//               .orElseThrow(()->new UserNotFoundException(sup_id));
//    }
@GetMapping("/update/{sup_id}") //for lodesupplier
Supplier getSupplierById(@PathVariable("sup_id") Long sup_id){
    return supplierRepository.findById(sup_id)
            .orElseThrow(()->new UserNotFoundException(sup_id));
}


    @PutMapping("/get-supplier/{sup_id}")
    Supplier updateSupplier(@RequestBody Supplier newSupplier,@PathVariable Long sup_id){


        return supplierRepository.findById(sup_id)
                .map(supplier->{
                    supplier.setSupname(newSupplier.getSupname());
                    supplier.setIdNumber(newSupplier.getIdNumber());
                    supplier.setAddress(newSupplier.getAddress());
                    supplier.setPhonenumber(newSupplier.getPhonenumber());
                    supplier.setItemName(newSupplier.getItemName());
                    supplier.setEmail(newSupplier.getEmail());

                    return supplierRepository.save(supplier);
                }).orElseThrow(()->new UserNotFoundException(sup_id));
    }



    @DeleteMapping("/supplier/{sup_id}")
    String deletesup(@PathVariable Long sup_id){
        if(!supplierRepository.existsById(sup_id)){
//            throw new UserNotFoundException(sup_id);
            return "User Not Found";
        }else supplierRepository.deleteById(sup_id);
        return sup_id+" "+" was deleted";
    }

//    @DeleteMapping("/supplier/{sup_id}")
//    public ResponseEntity<String> deletesup(@PathVariable Long sup_id){
//        if(!supplierRepository.existsById(sup_id)){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
//        }
//
//        // Check if the supplier has a non-zero balance
//        List<Payment> payments = (List<Payment>) paymentRepository. findById(sup_id);
//        double totalBalance = payments.stream()
//                .mapToDouble(Payment::getBalance)
//                .sum();
//
//        if (totalBalance > 0) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Supplier has a payment balance, so cannot be deleted.");
//        }
//
//        // If balance is 0, delete the supplier
//        supplierRepository.deleteById(sup_id);
//        return ResponseEntity.ok(sup_id + " was deleted");
//    }


}







//    @PutMapping("/test/{id}")
//    void demofunction(@PathVariable Long id){
//        System.out.println("success call");
//        System.out.println("id : "+ id);
////        System.out.println("dto value : "+ dto.getSuppName());
//    }
//    @PutMapping("/save-supplier/{sup_id}")
//    Supplier test(@RequestBody Supplier newSupplier,@PathVariable("sup_id") Long sup_id){
//        //System.out.println(newSupplier);
//        return null;
//    }

//    @DeleteMapping("/delete-supplier/{sup_id}")
//    String deletesup(@PathVariable("sup_id") Long sup_id ){
//        if(!supplierRepository.existsById(sup_id)){
//            throw new UserNotFoundException(sup_id);
//        }
//        supplierRepository.deleteById(sup_id);
//        return sup_id+" "+" was deleted";
//    }

