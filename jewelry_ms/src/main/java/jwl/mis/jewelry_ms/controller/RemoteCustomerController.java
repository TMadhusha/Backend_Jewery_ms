package jwl.mis.jewelry_ms.controller;

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
