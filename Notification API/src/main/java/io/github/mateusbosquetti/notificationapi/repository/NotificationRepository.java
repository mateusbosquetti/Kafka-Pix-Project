package io.github.mateusbosquetti.notificationapi.repository;

import io.github.mateusbosquetti.notificationapi.model.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
