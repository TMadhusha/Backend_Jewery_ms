package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Item;
import jwl.mis.jewelry_ms.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments,Long> {
}
