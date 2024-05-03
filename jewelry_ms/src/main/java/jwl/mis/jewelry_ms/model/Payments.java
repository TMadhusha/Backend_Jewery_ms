package jwl.mis.jewelry_ms.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order_details orderDetails;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private double paymentAmount;
    private String paymentMethod;
    private LocalDateTime transactionDateTime;
    private String notes;

    public Payments() {
    }

    public Payments(Long payment_id, Order_details orderDetails, String customerName, String customerEmail, String customerPhone, double paymentAmount, String paymentMethod, LocalDateTime transactionDateTime, String notes) {
        this.payment_id = payment_id;
        this.orderDetails = orderDetails;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.transactionDateTime = transactionDateTime;
        this.notes = notes;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Order_details getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Order_details orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}