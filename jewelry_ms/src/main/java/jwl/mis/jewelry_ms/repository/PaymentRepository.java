package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Admin;
import jwl.mis.jewelry_ms.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {


}
