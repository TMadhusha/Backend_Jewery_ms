package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.MyCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyCartRepository extends JpaRepository<MyCart, Integer> {
    List<MyCart> findByUsername(String username);
}
