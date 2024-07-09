package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.RemoteCustomers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RemoteCustomerRepository extends JpaRepository<RemoteCustomers,Long> {
    RemoteCustomers findByUsernameAndPassword(String username, String password);
    Optional<RemoteCustomers> findByUsername(String username);

}
