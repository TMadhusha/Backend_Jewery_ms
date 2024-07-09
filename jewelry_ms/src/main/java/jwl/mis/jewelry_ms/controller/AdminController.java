package jwl.mis.jewelry_ms.controller;

import  jwl.mis.jewelry_ms.Models.AdminLoginRequest;
import jwl.mis.jewelry_ms.exception.UserNotFoundException;
import jwl.mis.jewelry_ms.model.Admin;

import jwl.mis.jewelry_ms.model.Employee;
import jwl.mis.jewelry_ms.repository.AdminRepository;
import jwl.mis.jewelry_ms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping("/api/supplier")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
         //Admin Register
//    @PostMapping("/register")
//    Admin newAdmin(@RequestBody Admin newAdmin ){
//
//        return adminRepository.save(newAdmin);
//
//    }

    @PostMapping("/register")
    ResponseEntity<?> newAdmin(@RequestBody Admin newAdmin) {
        String emp_id = newAdmin.getId(); // Get the emp_id from the new admin object

        // Check if emp_id exists in the employee table
        Optional<Employee> optionalEmployee = employeeRepository.findById(emp_id);

        if (optionalEmployee.isPresent()) {
            // If emp_id exists, save the new admin
            Admin savedAdmin = adminRepository.save(newAdmin);
            return ResponseEntity.ok(savedAdmin);
        } else {
            // If emp_id does not exist, return an error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee ID not found. Please enter a valid Employee ID.");
        }
    }






    //Delete An admin
    @DeleteMapping("/delete-supplier/{adminid}")
    String deleteadmin(@PathVariable("adminid") Long adminid ){
        if(!adminRepository.existsById(adminid)){
            throw new UserNotFoundException(adminid);
        }
        adminRepository.deleteById(adminid);
        return adminid+" "+" was deleted";
    }



    // Check if username and password match
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminLoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();



        // Find the admin by username
        Admin admin = adminRepository.findAdminByUsername(username);

        if (admin == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } else {
            if (admin.getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        }
    }

    // Update Admin Password
    @PutMapping("/forgetpwd")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> requestBody) {
        try {
            String username = requestBody.get("username");
            String newPassword = requestBody.get("password");

            // Find the admin by username
            Admin admin = adminRepository.findAdminByUsername(username);

            if (admin == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username is Incorrect");
            } else {
                // Update password and save
                admin.setPassword(newPassword);
                adminRepository.save(admin);
                return ResponseEntity.ok("Password updated successfully");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating password: " + e.getMessage());
        }
    }


}



