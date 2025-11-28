package com.vwaiter;

import com.vwaiter.common.NotificationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Data
@Document(collection = "notifications")
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    private String notificationId;
    private Date createdWhen;
    private String recipientId;
    private NotificationType type;
    private Long templateId;
    private String message;
    private Map<String, Object> params;
}
