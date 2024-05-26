package com.shopping.os.app.service;

import com.shopping.os.app.common.Payment;
import com.shopping.os.app.common.TransactionRequest;
import com.shopping.os.app.common.TransactionResponse;
import com.shopping.os.app.entity.Order;
import com.shopping.os.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request) {
        Order order = request.getOrder();
        Payment payment = Payment.builder()
                .orderId(order.getOrderId())
                .price(order.getPrice())
                .build();

        Payment paymentResponse = restTemplate.postForObject("http://payment-service/payment/processPayment", payment, Payment.class);
        orderRepository.save(order);
        return TransactionResponse.builder()
                .order(order)
                .transactionId(paymentResponse.getTransactionId())
                .orderStatus(paymentResponse.getPaymentStatus())
                .build();
    }
}
