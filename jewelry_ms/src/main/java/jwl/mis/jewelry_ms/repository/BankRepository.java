package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Admin;
import jwl.mis.jewelry_ms.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Long> {
    Bank findBankByUsername(String username);

}
