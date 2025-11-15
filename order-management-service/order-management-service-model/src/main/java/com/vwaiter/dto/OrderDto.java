package com.vwaiter.dto;

import com.vwaiter.common.OrderStatus;
import com.vwaiter.common.PaymentInstrument;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class OrderDto {
    Long customerId;
    Date createdWhen;
    OrderStatus status;
    int tableId;
    Long waiterId;
    List<OrderItemDto> orderItems;
    PaymentInstrument paidBy;
    Date paidWhen;
}
