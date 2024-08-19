package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.SalesAndRevenues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SalesAndRevenueRepository extends JpaRepository<SalesAndRevenues,Long> {
    @Query("SELECT s FROM SalesAndRevenues s JOIN FETCH s.customer WHERE s.transactionId = :transactionId")
    Optional<SalesAndRevenues> findByTransactionIdWithCustomer(@Param("transactionId")Long transactionId);
}
