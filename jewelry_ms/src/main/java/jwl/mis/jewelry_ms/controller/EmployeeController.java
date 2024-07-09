package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.EmployeeNotFoundException;
import jwl.mis.jewelry_ms.model.Employee;
import jwl.mis.jewelry_ms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    //post the values to the database

//    Employee newEmployee(@RequestBody Employee newEmployee){
//        return employeeRepository.save(newEmployee);
//    }
    @PostMapping("/employee")
    Employee newEmployee(@RequestParam ("emp_id") String emp_id,
                         @RequestParam ("firstname") String firstname,
                         @RequestParam ("lastname") String lastname,
                         @RequestParam ("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
                         @RequestParam ("address") String address,
                         @RequestParam ("nic") String nic,
                         @RequestParam ("email") String email,
                         @RequestParam ("phoneNo") String phoneNo,
                         @RequestParam ("role") String role,
                         @RequestParam ("image")MultipartFile image){

        Employee newEmployee=new Employee();
        newEmployee.setEmp_id(emp_id);
        newEmployee.setFirstname(firstname);
        newEmployee.setLastname(lastname);
        newEmployee.setDob(dob);
        newEmployee.setAddress(address);
        newEmployee.setNic(nic);
        newEmployee.setEmail(email);
        newEmployee.setPhoneNo(phoneNo);
        newEmployee.setRole(role);
        try{
            newEmployee.setImage(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeRepository.save(newEmployee);
    }

    //get values form database
    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //get values by using specific Id for updation
    @GetMapping("/employee/{emp_id}")
    Employee getEmployeeById(@PathVariable String emp_id){
        return employeeRepository.findById(emp_id)
                .orElseThrow(()->new EmployeeNotFoundException(emp_id));
    }

   //update the specific values by using the Id
    @PutMapping("/employee/{emp_id}")
    Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable String emp_id){
        try{
            //Fetch the existing employee details
            Employee existingEmployee=employeeRepository.findById(String.valueOf(emp_id))
                    .orElseThrow(()-> new EmployeeNotFoundException(emp_id));

            //Update the properties of existing employee
            existingEmployee.setFirstname(newEmployee.getFirstname());
            existingEmployee.setLastname(newEmployee.getLastname());
            existingEmployee.setAddress(newEmployee.getAddress());
            existingEmployee.setEmail(newEmployee.getEmail());
            existingEmployee.setPhoneNo(newEmployee.getPhoneNo());
            existingEmployee.setImage(newEmployee.getImage());

            //save all the details
            return employeeRepository.save(existingEmployee);
        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //delete the specific Id
    @DeleteMapping("/employee/{emp_id}")
    String deleteEmployee(@PathVariable String emp_id){
        if(!employeeRepository.existsById(emp_id)){
            throw new EmployeeNotFoundException(emp_id);
        }
        employeeRepository.deleteById(emp_id);
        return "Employee with ID "+emp_id+ " has been deleted succesfully";
    }
}
