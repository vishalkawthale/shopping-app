package com.shopping.ps.app.service;

import com.shopping.ps.app.entity.Payment;
import com.shopping.ps.app.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        payment.setPaymentStatus(paymentStatus());
        payment.setTransactionId(UUID.randomUUID().toString());
        return this.paymentRepository.save(payment);
    }

    private String paymentStatus() {
        return new Random().nextBoolean() ? "success" : "failed";
    }

    public Payment getPaymentDetails(Integer orderId) {
        return this.paymentRepository.findByOrderId(orderId);
    }
}
