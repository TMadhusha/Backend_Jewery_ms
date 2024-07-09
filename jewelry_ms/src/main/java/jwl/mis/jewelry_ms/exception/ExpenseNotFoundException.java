package jwl.mis.jewelry_ms.exception;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(Long expenseId){
        super("Could not found the expense id " +expenseId);
    }
}
