package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
