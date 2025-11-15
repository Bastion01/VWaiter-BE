package com.vwaiter.dto;

import com.vwaiter.common.Currency;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DishDto {
    public String name;
    public Integer weight;
    public String composition;
    public Integer price;
    public Currency currency;
    public Float rating;
    public Integer reviewsAmount;
}
