//package jwl.mis.jewelry_ms.repository;
//
//import jwl.mis.jewelry_ms.model.Cart;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface CartRepository extends JpaRepository<Cart,Long> {
//}
package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUsername(String username);
}
