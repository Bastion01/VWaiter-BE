package com.vwaiter.dto;

import com.vwaiter.OrderPaymentItem;
import com.vwaiter.common.PaymentInstrument;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderPaymentDto {
    private Long orderId;
    private String b2bCustomerName;
    private String waiterName;
    private Integer tableId;
    private List<OrderPaymentItem> orderPaymentItems;
    private Float totalPrice;
    private PaymentInstrument paidBy;
    private Date paidWhen;
}
