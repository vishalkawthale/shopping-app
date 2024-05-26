package com.shopping.os.app.common;

import com.shopping.os.app.entity.Order;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponse {

    private Order order;
    private String transactionId;
    private String orderStatus;
}
