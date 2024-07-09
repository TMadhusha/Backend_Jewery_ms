package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByOrderId(Long orderId);
}
