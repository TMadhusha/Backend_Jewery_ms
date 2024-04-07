package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.model.Attendance;
import jwl.mis.jewelry_ms.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostMapping("/attendanceP")
    Attendance newAttendance(@RequestBody Attendance newAttendance){
       return attendanceRepository.save(newAttendance);
    }
}
