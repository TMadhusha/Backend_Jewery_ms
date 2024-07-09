package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.RemoteCustomersNotFoundException;
import jwl.mis.jewelry_ms.model.RemoteCustomerLoginRequest;
import jwl.mis.jewelry_ms.model.RemoteCustomers;
import jwl.mis.jewelry_ms.repository.RemoteCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RemoteCustomerController {
    @Autowired
    private RemoteCustomerRepository remoteCustomerRepository;

    public RemoteCustomerController(RemoteCustomerRepository remoteCustomerRepository) {
        this.remoteCustomerRepository = remoteCustomerRepository;
    }

    @PostMapping("/remoteCustomersP")
//    RemoteCustomers newRemoteCustomers(@RequestBody RemoteCustomers newRemotecustomers){
//        return remoteCustomerRepository.save(newRemotecustomers);
//    }

    RemoteCustomers newRemoteCustomers(@RequestParam ("firstname") String firstname,
                                       @RequestParam ("lastname") String lastname,
                                       @RequestParam ("address") String address,
                                       @RequestParam ("email") String email,
                                       @RequestParam ("phoneNo") String phoneNo,
                                       @RequestParam ("username") String username,
                                       @RequestParam ("password") String password,
                                       @RequestParam ("dp") MultipartFile dp){
        RemoteCustomers newRemoteCustomers=new RemoteCustomers();
        newRemoteCustomers.setFirstname(firstname);
        newRemoteCustomers.setLastname(lastname);
        newRemoteCustomers.setAddress(address);
        newRemoteCustomers.setEmail(email);
        newRemoteCustomers.setPhoneNo(phoneNo);
        newRemoteCustomers.setUsername(username);
        newRemoteCustomers.setPassword(password);
        if (dp != null) {
            try {
                newRemoteCustomers.setDp(dp.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return remoteCustomerRepository.save(newRemoteCustomers);
    }

    @GetMapping("/remoteCustomersG")
    List<RemoteCustomers> getAllRemoteCustomers() {
        return remoteCustomerRepository.findAll();
    }



    @PutMapping("/updateRemoteCustomers/{username}")
    public RemoteCustomers updateRemoteCustomer(
            @PathVariable String username,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("phoneNo") String phoneNo,
            @RequestParam("password") String password,
            @RequestParam(value = "dp", required = false) MultipartFile dp) throws IOException {

        RemoteCustomers existingRemoteCustomer = remoteCustomerRepository.findByUsername(username)
                .orElseThrow(() -> new RemoteCustomersNotFoundException(username));

        // Update customer details
        existingRemoteCustomer.setFirstname(firstname);
        existingRemoteCustomer.setLastname(lastname);
        existingRemoteCustomer.setEmail(email);
        existingRemoteCustomer.setAddress(address);
        existingRemoteCustomer.setPhoneNo(phoneNo);
        existingRemoteCustomer.setPassword(password);

        // Handle profile picture upload if provided
        if (dp != null && !dp.isEmpty()) {
            existingRemoteCustomer.setDp(dp.getBytes()); // Save profile picture as byte array
        }

        return remoteCustomerRepository.save(existingRemoteCustomer);
    }

    // Exception handler for customer not found
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RemoteCustomersNotFoundException.class)
    public String handleRemoteCustomersNotFoundException(RemoteCustomersNotFoundException ex) {
        return ex.getMessage();
    }


    @GetMapping("/remoteCustomersGetById/{username}")
    RemoteCustomers getById(@PathVariable String username) {
        return remoteCustomerRepository.findByUsername(username)
                .orElseThrow(() -> new RemoteCustomersNotFoundException(username));
    }

    @DeleteMapping("/deleteRemoteCustomers/{cus_id}")
    String deleteRemoteCustomers(@PathVariable Long cus_id) {
        if (!remoteCustomerRepository.existsById(cus_id)) {
            throw new RemoteCustomersNotFoundException(cus_id);
        } else {
            remoteCustomerRepository.deleteById(cus_id);
            return "Deleted";
        }
    }

    @PostMapping("/remoteCustomerLogin")
    public ResponseEntity<String> loginRemoteCustomer(@RequestBody RemoteCustomerLoginRequest request) {
        RemoteCustomers remoteCustomers = remoteCustomerRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (remoteCustomers != null) {
            return ResponseEntity.ok("Login Successfull");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }


}
