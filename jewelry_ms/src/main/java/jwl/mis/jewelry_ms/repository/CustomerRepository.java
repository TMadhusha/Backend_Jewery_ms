package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT MAX(c.cus_id) FROM Customer c")
    Long findMaxCustomerId();


}
