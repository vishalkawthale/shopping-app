package com.shopping.cloud.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @PostMapping(value = "/orderFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order service taking time to respond or may be down. Please try again later");
    }

    @PostMapping(value = "/paymentFallBack")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Payment service taking time to respond or may be down. Please try again later");
    }
}
