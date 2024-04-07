package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.EmployeeNotFoundException;
import jwl.mis.jewelry_ms.model.Employee;
import jwl.mis.jewelry_ms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    //post the values to the database
    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee){
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
//    @PutMapping("/employee/{id}")
//    Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable Long id){
//        return employeeRepository.findById(id)
//                .map(employee -> {
//                    employee.setFirstname(newEmployee.getFirstname());
//                    employee.setLastname(newEmployee.getLastname());
//                    employee.setAddress(newEmployee.getAddress());
//                    employee.setEmail(newEmployee.getEmail());
//                    employee.setPhoneNo(newEmployee.getPhoneNo());
//                    employee.setRole(newEmployee.getRole());
//                    return employeeRepository.save(employee);
//                }).orElseThrow(()->new EmployeeNotFoundException(id));
//    }
//
//    //delete the specific Id
//    @DeleteMapping("/employee/{id}")
//    String deleteEmployee(@PathVariable Long id){
//        if(!employeeRepository.existsById(id)){
//            throw new EmployeeNotFoundException(id);
//        }
//        employeeRepository.deleteById(id);
//        return "Employee with ID "+id+ " has been deleted succesfully";
//    }
}
