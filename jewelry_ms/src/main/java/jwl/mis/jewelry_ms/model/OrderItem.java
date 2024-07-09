package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_items") // Specify the table name explicitly
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id") // Map to the actual column name in the database
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id") // Name of the foreign key column in the order_items table
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id") // Name of the foreign key column in the order_items table
    private Inventory inventory;

    private int quantity;
    private double sellingPrice;

    @Column(name = "total_price") // Map to the actual column name in the database
    private double totalPrice;

    // Constructors
    public OrderItem(Long orderItemId, Order order, Inventory inventory, int quantity, double sellingPrice, double totalPrice) {
        this.orderItemId = orderItemId;
        this.order = order;
        this.inventory = inventory;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.totalPrice = totalPrice;
    }

    public OrderItem() {
    }
}
