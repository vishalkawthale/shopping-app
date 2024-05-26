package com.shopping.os.app.controller;

import com.shopping.os.app.common.TransactionRequest;
import com.shopping.os.app.common.TransactionResponse;
import com.shopping.os.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/processOrder")
    public TransactionResponse processOrder(@RequestBody TransactionRequest request) {
        return this.orderService.saveOrder(request);
    }
}
