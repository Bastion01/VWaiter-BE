package com.vwaiter.mappers;

import com.vwaiter.Dish;
import com.vwaiter.dto.DishDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DishMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDishFromDto(DishDto dto, @MappingTarget Dish entity);
}
