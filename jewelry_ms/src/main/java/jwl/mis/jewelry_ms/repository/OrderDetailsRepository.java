package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Order_details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<Order_details,Long> {
}
