package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

}
