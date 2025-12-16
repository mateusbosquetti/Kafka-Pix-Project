package io.github.mateusbosquetti.notificationapi.service;

import io.github.mateusbosquetti.notificationapi.model.entity.Notification;
import io.github.mateusbosquetti.notificationapi.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public Notification createNotification (String message, Long userId) {
        Notification notification = Notification.builder()
                .message(message)
                .userId(userId)
                .build();
        return this.repository.save(notification);
    }

}
