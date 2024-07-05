//package jwl.mis.jewelry_ms.repository;
//
//import jwl.mis.jewelry_ms.model.RemoteCustomers;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface RemoteCustomerRepository extends JpaRepository<RemoteCustomers,Long> {
//    RemoteCustomers findByUsernameAndPassword(String username, String password);
//}
package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.RemoteCustomers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemoteCustomerRepository extends JpaRepository<RemoteCustomers, Long> {
    RemoteCustomers findByUsername(String username);
    RemoteCustomers findByUsernameAndPassword(String username, String password);
}
