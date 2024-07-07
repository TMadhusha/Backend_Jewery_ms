package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
