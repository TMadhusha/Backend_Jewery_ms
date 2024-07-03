package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
