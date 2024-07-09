package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.MyCart;
import jwl.mis.jewelry_ms.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyCartRepository extends JpaRepository<MyCart,Long> {
    Optional<MyCart> findByUsername(String username);
}
