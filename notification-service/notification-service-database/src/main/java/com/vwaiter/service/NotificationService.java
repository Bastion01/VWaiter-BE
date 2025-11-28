package com.vwaiter.service;

import com.vwaiter.Notification;
import com.vwaiter.repository.NotificationRepository;
import com.vwaiter.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final RecipientRepository recipientRepository;
    private final NotificationRepository notificationRepository;
    private final RecipientService recipientService;

    public Notification findById(String id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public List<Notification> findAll() {
        Iterable<Notification> notificationIterable = notificationRepository.findAll();
        List<Notification> notificationList = new ArrayList<>();
        notificationIterable.iterator().forEachRemaining(notificationList::add);
        return notificationList;
    }

    public void save(Notification notification) {
        notificationRepository.save(notification);
        recipientService.addNotification(notification.getRecipientId(), notification);
    }

    public void delete(Notification notification) {
        notificationRepository.delete(notification);
    }
}