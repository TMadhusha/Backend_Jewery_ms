package jwl.mis.jewelry_ms.exception;

public class OrderDetailsNotFoundException extends RuntimeException{
    public OrderDetailsNotFoundException (Long order_id){
        super("Could not find the reservation with id " + order_id);
    }
}
