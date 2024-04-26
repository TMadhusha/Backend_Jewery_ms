package jwl.mis.jewelry_ms.exception;

public class ReturnsNotFoundException extends RuntimeException{
    public ReturnsNotFoundException(Long return_id ){
        super("Could not find the returns with id " + return_id);
    }
}
