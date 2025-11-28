package com.vwaiter.controllers.rest.mappers;

import com.vwaiter.Notification;
import com.vwaiter.dto.NotificationDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNotificationFromDto(NotificationDto notificationDto, @MappingTarget Notification notification);
}
