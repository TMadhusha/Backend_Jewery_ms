package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.repository.AttendanceRepository;
import jwl.mis.jewelry_ms.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryController {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    SalaryRepository salaryRepository;
}
