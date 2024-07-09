package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.MyCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCartRepo extends JpaRepository<MyCart,Long> {
}
