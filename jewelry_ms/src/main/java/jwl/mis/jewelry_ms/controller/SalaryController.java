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