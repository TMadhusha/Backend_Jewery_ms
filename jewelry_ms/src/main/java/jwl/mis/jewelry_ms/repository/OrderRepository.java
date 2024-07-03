package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.OnlinePayments;
import jwl.mis.jewelry_ms.model.Order_details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order_details, Long> {
    // Define custom query methods if needed
}
