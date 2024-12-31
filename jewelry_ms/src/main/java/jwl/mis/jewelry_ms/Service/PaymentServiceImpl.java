package jwl.mis.jewelry_ms.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import jwl.mis.jewelry_ms.model.Order;
import jwl.mis.jewelry_ms.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Service
public class PaymentServiceImpl implements PaymentService{

    @Value("${stripe.api.key}")
    private String stripeSecreteKey;
    @Override
    public PaymentResponse createLink(Order order) throws StripeException {
        Stripe.apiKey=stripeSecreteKey;

        SessionCreateParams sessionCreateParams=SessionCreateParams.builder().addPaymentMethodType(
                SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:3000/success"+order.getOrderId())
                .setCancelUrl("http://localhost:3000/fail")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1L).setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("usd")
                                .setUnitAmount((long) order.getTotalAmount()*100)
                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName("Italy Silver Choice")
                                        .build())
                                .build()
                        )
                        .build()
                )
                .build();

        Session session=Session.create(sessionCreateParams);

        PaymentResponse paymentResponse=new PaymentResponse();
        paymentResponse.setPayment_url(session.getUrl());

        return paymentResponse;
    }
}
