package com.vwaiter.controllers.rest;

import com.vwaiter.Notification;
import com.vwaiter.controllers.rest.mappers.NotificationMapper;
import com.vwaiter.dto.NotificationDto;
import com.vwaiter.service.NotificationService;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@AllArgsConstructor
public class NotificationController {
    private NotificationService notificationService;
    private NotificationMapper notificationMapper = Mappers.getMapper(NotificationMapper.class);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Notification> getNotification(@PathVariable String id) {
        Notification notification = notificationService.findById(id);
        return ResponseEntity.ok(notification);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> getNotifications() {
        List<Notification> notifications = notificationService.findAll();
        return ResponseEntity.ok(notifications);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        notificationService.save(notification);
        return ResponseEntity.ok(notification);
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Notification> updateNotification(@PathVariable String id, @RequestBody NotificationDto notificationDto) {
        Notification notification = notificationService.findById(id);
        if (notification != null) {
            notificationMapper.updateNotificationFromDto(notificationDto, notification);
            notificationService.save(notification);
        }
        return new ResponseEntity<>(notification, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteNotification(@PathVariable String id) {
        Notification notification = notificationService.findById(id);
        notificationService.delete(notification);
        return HttpStatus.NO_CONTENT;
    }
}
