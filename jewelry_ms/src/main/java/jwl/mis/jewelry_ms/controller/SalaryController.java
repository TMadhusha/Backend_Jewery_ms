package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.AttendanceNotFoundException;
import jwl.mis.jewelry_ms.model.Attendance;
import jwl.mis.jewelry_ms.model.Salary;
import jwl.mis.jewelry_ms.repository.AttendanceRepository;
import jwl.mis.jewelry_ms.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SalaryController {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    SalaryRepository salaryRepository;

    @PostMapping("/salaryP")
    Salary newSalary(@RequestBody Salary newSalary){
        return salaryRepository.save(newSalary);
    }

    @GetMapping("/salaryG")
    List<Salary> getAllSalary(){
        return salaryRepository.findAll();
    }


}
    //@PostMapping("/calculate-salary")
//    public Salary calculateSalaryForEmployee(@RequestBody SalaryRequest request) {
//        // Retrieve attendance records for the specific employee for the given month
//        List<Attendance> attendanceRecords = attendanceRepository.findById(request.getEmpId(), request.getMonth());
//
//        // Calculate total working hours based on the retrieved attendance records
//        double totalWorkingHours = calculateTotalWorkingHours(attendanceRecords);
//
//        // Calculate the salary based on total working hours (you may have your own formula)
//        double totalSalary = calculateSalary(totalWorkingHours);
//
//        // Create a new Salary object and store it in the database
//        Salary salary = new Salary();
//        salary.setEmp_id(request.getEmpId());
//        salary.setMonth(request.getMonth());
//        salary.setTotalWorkingHours(totalWorkingHours);
//        salary.setTotalAmount(totalSalary);
//        salaryRepository.save(salary);
//
//        return salary;
//    }
//}
