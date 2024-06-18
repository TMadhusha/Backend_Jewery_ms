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

        try{
            newRemoteCustomers.setFirstname(firstname);
            newRemoteCustomers.setLastname(lastname);
            newRemoteCustomers.setAddress(address);
            newRemoteCustomers.setEmail(email);
            newRemoteCustomers.setPhoneNo(phoneNo);
            newRemoteCustomers.setUsername(username);
            newRemoteCustomers.setPassword(password);
            newRemoteCustomers.setDp(dp.getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }
        return remoteCustomerRepository.save(newRemoteCustomers);
    }

    @GetMapping("/remoteCustomersG")
    List<RemoteCustomers> getAllRemoteCustomers(){
        return remoteCustomerRepository.findAll();
    }

    @GetMapping("/remoteCustomersGetById/{cus_id}")
    RemoteCustomers getById(@PathVariable Long cus_id){
        return remoteCustomerRepository.findById(cus_id)
                .orElseThrow(()-> new RemoteCustomersNotFoundException(cus_id));
    }

    @PutMapping("/updateRemoteCustomers/{Id")
    RemoteCustomers updateRemoteCustomers(@RequestBody RemoteCustomers newRemoteCustomer,@PathVariable Long cus_id){
        try {
            RemoteCustomers existingRemoteCustomer=remoteCustomerRepository.findById(Long.valueOf(cus_id))
                    .orElseThrow(()->new RemoteCustomersNotFoundException(cus_id));

            //update remote customers
            existingRemoteCustomer.setFirstname(newRemoteCustomer.getFirstname());
            existingRemoteCustomer.setLastname(newRemoteCustomer.getLastname());
            existingRemoteCustomer.setEmail(newRemoteCustomer.getEmail());
            existingRemoteCustomer.setAddress(newRemoteCustomer.getAddress());
            existingRemoteCustomer.setPhoneNo(newRemoteCustomer.getPhoneNo());
            existingRemoteCustomer.setUsername(newRemoteCustomer.getUsername());
            existingRemoteCustomer.setDp(newRemoteCustomer.getDp());

            return remoteCustomerRepository.save(existingRemoteCustomer);
        } catch (RemoteCustomersNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/remoteCustomerLogin")
    public ResponseEntity<String> loginRemoteCustomer(@RequestBody RemoteCustomerLoginRequest request){
        RemoteCustomers remoteCustomers=remoteCustomerRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if(remoteCustomers!=null){
            return ResponseEntity.ok("Login Successfull");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
