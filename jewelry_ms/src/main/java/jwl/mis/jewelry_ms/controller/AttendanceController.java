package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.AttendanceNotFoundException;
import jwl.mis.jewelry_ms.model.Attendance;
import jwl.mis.jewelry_ms.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AttendanceController {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostMapping("/attendanceP")
    Attendance newAttendance(@RequestBody Attendance newAttendance){
       return attendanceRepository.save(newAttendance);
    }

    @GetMapping("/attendanceG")
    List<Attendance> getAllAttendance(){
        return attendanceRepository.findAll();
    }

    @GetMapping("/attendance/{att_id}")
    Attendance getAttendanceById(@PathVariable String att_id){
        return attendanceRepository.findById(att_id)
                .orElseThrow(()->new AttendanceNotFoundException(att_id));
    }

    @PutMapping("/attendance/{att_id}")
    Attendance updateAttendance(@RequestBody Attendance newAttendance,@PathVariable String att_id){
        return attendanceRepository.findById(att_id)
                .map(attendance -> {
                    attendance.setCheck_Out(newAttendance.getCheck_Out());
                    return attendanceRepository.save(attendance);
                }).orElseThrow(()->new AttendanceNotFoundException(att_id));
    }

}
