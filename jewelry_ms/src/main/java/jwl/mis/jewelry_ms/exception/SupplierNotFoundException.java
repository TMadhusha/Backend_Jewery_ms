package jwl.mis.jewelry_ms.exception;

public class SupplierNotFoundException extends RuntimeException{
    public SupplierNotFoundException(String sup_id){
        super(sup_id+" "+"Is not Valid...");
    }
}
