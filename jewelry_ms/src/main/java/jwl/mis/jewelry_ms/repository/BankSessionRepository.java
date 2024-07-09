package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Bank;
import jwl.mis.jewelry_ms.model.BankSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankSessionRepository extends JpaRepository<BankSession,Long> {
    BankSession findBankSessionByAccountnumber(String accountnumber);

}
