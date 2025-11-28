package com.vwaiter.dto;

import com.vwaiter.common.Currency;
import lombok.Data;

@Data
public class OrderPaymentItemDto {
    private String name;
    private Integer amount;
    private Float price;
    private Currency currency;
}
