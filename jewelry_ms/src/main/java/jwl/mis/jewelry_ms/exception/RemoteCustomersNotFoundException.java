package jwl.mis.jewelry_ms.exception;

public class RemoteCustomersNotFoundException extends RuntimeException{
    public RemoteCustomersNotFoundException(Long Id){
        super("Could not found this Id "+Id);
    }
}
