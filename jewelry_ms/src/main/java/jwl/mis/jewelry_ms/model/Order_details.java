package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Order_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    @Temporal(TemporalType.DATE)
    private Date order_date;
    private Double total_amount;

    private String order_status;
    @Temporal(TemporalType.DATE)
    private Date pickup_date;
    private String notes;

    private String quantity;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item Item;

    public Order_details(Long order_id, Date order_date, Double total_amount, String order_status, Date pickup_date, String notes, String quantity, Customer customer, jwl.mis.jewelry_ms.model.Item item) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
        this.order_status = order_status;
        this.pickup_date = pickup_date;
        this.notes = notes;
        this.quantity = quantity;
        this.customer = customer;
        Item = item;
    }

    public Order_details() {

    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Date getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(Date pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public jwl.mis.jewelry_ms.model.Item getItem() {
        return Item;
    }

    public void setItem(jwl.mis.jewelry_ms.model.Item item) {
        Item = item;
    }
}