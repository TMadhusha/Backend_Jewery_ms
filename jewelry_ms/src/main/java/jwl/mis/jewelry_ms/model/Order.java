package jwl.mis.jewelry_ms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "orders") // Specify the table name explicitly
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id") // Map to the actual column name in the database
    private long orderId; // Use camelCase for consistency

    @ManyToOne
    @JoinColumn(name = "cus_id") // Name of the foreign key column in the orders table
    private Customer customer;


    @Temporal(TemporalType.DATE)
    @Column(name = "order_date") // Map to the actual column name in the database
    private Date orderDate;

    @Column(name = "total_amount") // Map to the actual column name in the database
    private double totalAmount;

    @Column(name = "order_status") // Map to the actual column name in the database
    private String orderStatus;

    @Column(name = "payment_method") // Map to the actual column name in the database
    private String paymentMethod;

    @Column(name = "billing_address") // Map to the actual column name in the database
    private String billingAddress;

    @Column(name = "pickup_date")
    private Date PickupDate;

    public Order(long orderId, Customer customer, Date orderDate, double totalAmount, String orderStatus, String paymentMethod, String billingAddress, Date pickupDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.billingAddress = billingAddress;
        PickupDate = pickupDate;
    }

    public Order() {
    }
}
