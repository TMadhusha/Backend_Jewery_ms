package jwl.mis.jewelry_ms.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long cus_id){
        super("could not found the user with id" + cus_id);
    }

}
