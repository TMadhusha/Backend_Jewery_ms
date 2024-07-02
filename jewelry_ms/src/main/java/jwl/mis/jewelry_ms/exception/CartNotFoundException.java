package jwl.mis.jewelry_ms.exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(Long Id){
        super("Could not found the cart with id "+Id);
    }
}
