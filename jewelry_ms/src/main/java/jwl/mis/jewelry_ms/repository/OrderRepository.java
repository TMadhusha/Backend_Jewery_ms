package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Order;
import jwl.mis.jewelry_ms.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByOrderId(Long orderId);


}
