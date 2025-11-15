package com.vwaiter.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDto {
    Long dishId;
    int amount;
}
