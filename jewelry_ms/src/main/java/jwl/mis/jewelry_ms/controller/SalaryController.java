package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Attendance;
import jwl.mis.jewelry_ms.model.Salary;
import jwl.mis.jewelry_ms.repository.AttendanceRepository;
import jwl.mis.jewelry_ms.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
public class SalaryController {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    SalaryRepository salaryRepository;




}
