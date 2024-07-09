package jwl.mis.jewelry_ms.exception;

public class PurchaseNotFoundException extends RuntimeException{
    public PurchaseNotFoundException(Long purchaseId){
        super("Could not found this Id "+purchaseId);
    }
}
