package io.github.mateusbosquetti.notificationapi.service;

import io.github.mateusbosquetti.notificationapi.model.dto.NotificationKafkaDTO;
import io.github.mateusbosquetti.notificationapi.model.entity.Notification;
import io.github.mateusbosquetti.notificationapi.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Notification createNotification (String message, Long userId) {
        Notification notification = Notification.builder()
                .message(message)
                .userId(userId)
                .build();
        notification = this.repository.save(notification);

        NotificationKafkaDTO kafkaDTO = new NotificationKafkaDTO(notification.getMessage(), notification.getUserId());
        kafkaTemplate.send("notification.sent", UUID.randomUUID().toString(), kafkaDTO);

        return notification;
    }

}
