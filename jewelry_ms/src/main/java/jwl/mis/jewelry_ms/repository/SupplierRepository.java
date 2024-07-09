package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Optional<Supplier> findByIdNumber(String idNumber);
}
