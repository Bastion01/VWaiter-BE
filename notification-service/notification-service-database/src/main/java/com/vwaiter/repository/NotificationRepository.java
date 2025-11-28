package com.vwaiter.repository;

import com.vwaiter.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, String> {
}
