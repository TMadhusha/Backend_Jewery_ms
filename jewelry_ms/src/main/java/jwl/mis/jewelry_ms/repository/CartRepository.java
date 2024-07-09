package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByUsername(String username);
}
