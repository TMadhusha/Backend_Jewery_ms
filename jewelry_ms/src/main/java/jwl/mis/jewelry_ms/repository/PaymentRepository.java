package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
