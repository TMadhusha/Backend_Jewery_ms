package jwl.mis.jewelry_ms.repository;

import jwl.mis.jewelry_ms.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}
