package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Customer;
import jwl.mis.jewelry_ms.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
