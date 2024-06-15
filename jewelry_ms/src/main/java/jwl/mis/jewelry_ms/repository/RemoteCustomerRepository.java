package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.RemoteCustomers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteCustomerRepository extends JpaRepository<RemoteCustomers,Long> {
}
