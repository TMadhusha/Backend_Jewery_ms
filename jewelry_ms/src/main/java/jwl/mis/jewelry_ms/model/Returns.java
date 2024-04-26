package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;

@Entity
public class Returns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long return_id;
    private String reason_for_return;
    private String preferred_resolution;

    private String additional_comments_notes;

    public Returns(Long return_id, String reason_for_return, String preferred_resolution, String additional_comments_notes, Customer customer, Order_details orderDetails) {
        this.return_id = return_id;
        this.reason_for_return = reason_for_return;
        this.preferred_resolution = preferred_resolution;
        this.additional_comments_notes = additional_comments_notes;
        this.customer = customer;

    }

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order_details orderDetails;

    public Returns() {

    }

    public Long getReturn_id() {
        return return_id;
    }

    public void setReturn_id(Long return_id) {
        this.return_id = return_id;
    }

    public String getReason_for_return() {
        return reason_for_return;
    }

    public void setReason_for_return(String reason_for_return) {
        this.reason_for_return = reason_for_return;
    }

    public String getPreferred_resolution() {
        return preferred_resolution;
    }

    public void setPreferred_resolution(String preferred_resolution) {
        this.preferred_resolution = preferred_resolution;
    }

    public String getAdditional_comments_notes() {
        return additional_comments_notes;
    }

    public void setAdditional_comments_notes(String additional_comments_notes) {
        this.additional_comments_notes = additional_comments_notes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}