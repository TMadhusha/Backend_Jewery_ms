package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.RemoteCustomers;
import jwl.mis.jewelry_ms.repository.RemoteCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    RemoteCustomers newRemoteCustomers(@RequestBody RemoteCustomers newRemotecustomers){
        return remoteCustomerRepository.save(newRemotecustomers);
    }
    @GetMapping("/remoteCustomersG")
    List<RemoteCustomers> getAllRemoteCustomers(){
        return remoteCustomerRepository.findAll();
    }


}
