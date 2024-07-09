package jwl.mis.jewelry_ms.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException (Long item_id){
        super("Could not find the item with id " + item_id);
    }
}
