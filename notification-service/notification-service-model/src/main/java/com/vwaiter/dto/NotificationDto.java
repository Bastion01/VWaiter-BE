package com.vwaiter.dto;

import com.vwaiter.common.NotificationType;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.Map;

@Setter
@Getter
public class NotificationDto {
    private Date createdWhen;
    private Long recipientId;
    private NotificationType type;
    private Long templateId;
    private String message;
    private Map<String, Object> params;
}
