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

    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
    }
    @PutMapping("/employee/{id}")
    Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable Long id){
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstname(newEmployee.getFirstname());
                    employee.setLastname(newEmployee.getLastname());
                    employee.setAddress(newEmployee.getAddress());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setPhoneNo(newEmployee.getPhoneNo());
                    employee.setRole(newEmployee.getRole());
                    return employeeRepository.save(employee);
                }).orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/employee/{id}")
    String deleteEmployee(@PathVariable Long id){
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        return "Employee with ID "+id+ " has been deleted succesfully";
    }
}
