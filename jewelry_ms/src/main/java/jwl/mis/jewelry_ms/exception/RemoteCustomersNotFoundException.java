package jwl.mis.jewelry_ms.exception;

public class RemoteCustomersNotFoundException extends RuntimeException{
    public RemoteCustomersNotFoundException(Long Id){
        super("Could not found this Id "+Id);
    }
    public RemoteCustomersNotFoundException(String username) {
        super("Could not find remote customer with username " + username);
    }

}
