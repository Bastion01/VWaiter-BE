package com.vwaiter.controllers.rest.mappers;

import com.vwaiter.OrderPayment;
import com.vwaiter.dto.OrderPaymentDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface OrderPaymentMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderFromDto(OrderPaymentDto orderPaymentDto, @MappingTarget OrderPayment orderPayment);
}
