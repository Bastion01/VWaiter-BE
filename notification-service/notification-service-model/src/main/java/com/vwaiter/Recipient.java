package com.vwaiter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "recipients")
@RequiredArgsConstructor
@AllArgsConstructor
public class Recipient {
    @Id
    private String id;
    private List<Notification> notifications;

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }
}
