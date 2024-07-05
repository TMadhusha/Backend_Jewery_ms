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


    @Column(name = "cus_id")
    private Long cus_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "billing_address")
    private String billingAddress;

    public Order(long orderId, Long cus_id, Date orderDate, double totalAmount, String orderStatus, String paymentMethod, String billingAddress) {
        this.orderId = orderId;
        this.cus_id = cus_id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.billingAddress = billingAddress;
    }

    public Order() {
    }
}
