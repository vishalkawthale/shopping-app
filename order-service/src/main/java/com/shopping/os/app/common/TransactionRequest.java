package com.shopping.os.app.common;

import com.shopping.os.app.entity.Order;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TransactionRequest {

    private Order order;
}
