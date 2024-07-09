package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;


    @Column(name = "username")
    private Long username;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "subtotal")
    private double subtotal;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "billing_address")
    private String billingAddress;

    public Order(long orderId, Long username, Date orderDate, double subtotal, String orderStatus, String paymentMethod, String billingAddress) {
        this.orderId = orderId;
        this.username = username;
        this.orderDate = orderDate;
        this.subtotal = subtotal;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.billingAddress = billingAddress;

    }

    public Order() {
    }
}
