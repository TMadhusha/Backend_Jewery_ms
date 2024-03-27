package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.AdminLogin;
import jwl.mis.jewelry_ms.repository.AdminLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminLoginController {
    @Autowired
    private AdminLoginRepository adminLoginRepository;

    @PostMapping("/adminlogin")
    AdminLogin newAdminLogin(@RequestBody AdminLogin newAdminLogin){
        return adminLoginRepository.save(newAdminLogin);
    }
}
