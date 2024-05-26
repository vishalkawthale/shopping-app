package com.shopping.ps.app.controller;

import com.shopping.ps.app.entity.Payment;
import com.shopping.ps.app.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/processPayment")
    public Payment processPayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }

    @GetMapping(value = "/{orderId}")
    public Payment getPaymentDetails(@PathVariable Integer orderId) {
        return this.paymentService.getPaymentDetails(orderId);
    }

}
