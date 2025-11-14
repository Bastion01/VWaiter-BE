package com.vwaiter.controller.rest.mappers;

import com.vwaiter.Order;
import com.vwaiter.dto.OrderDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderFromDto(OrderDto orderDto, @MappingTarget Order order);
}
