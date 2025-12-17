package io.github.mateusbosquetti.logapi.consumer;

import io.github.mateusbosquetti.logapi.model.dto.NotificationKafkaDTO;
import io.github.mateusbosquetti.logapi.model.dto.PixKafkaDTO;
import io.github.mateusbosquetti.logapi.service.LogService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogConsumer {

    private final LogService logService;

    @KafkaListener(topics = "pix.transaction.created", groupId = "log-group")
    public void consumePixOperation(PixKafkaDTO pixKafkaDTO) {
        this.logService.createLog("New pix to " + pixKafkaDTO.destinationUserId() + " from " + pixKafkaDTO.originUserId() + ", value: " + pixKafkaDTO.value());
    }

    @KafkaListener(topics = "notification.sent", groupId = "log-group")
    public void consumeNotificationOperation(NotificationKafkaDTO notificationKafkaDTO) {
        this.logService.createLog("New notification to "+ notificationKafkaDTO.userId() + ", content: " + notificationKafkaDTO.message());
    }

}
