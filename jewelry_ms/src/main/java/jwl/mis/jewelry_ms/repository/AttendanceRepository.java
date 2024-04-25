package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,String> {
}
