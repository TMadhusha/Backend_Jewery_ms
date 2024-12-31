package jwl.mis.jewelry_ms.Service;

import com.stripe.exception.StripeException;
import jwl.mis.jewelry_ms.model.Order;
import jwl.mis.jewelry_ms.response.PaymentResponse;

public interface PaymentService {
    public PaymentResponse createLink(Order order) throws StripeException;
}
