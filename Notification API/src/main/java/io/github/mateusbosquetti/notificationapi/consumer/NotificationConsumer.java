package io.github.mateusbosquetti.notificationapi.consumer;

import io.github.mateusbosquetti.notificationapi.model.dto.PixKafkaDTO;
import io.github.mateusbosquetti.notificationapi.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService service;

    @KafkaListener(topics = "CREATE_PIX_TOPIC", groupId = "test-group")
    public void consumir(PixKafkaDTO pixKafkaDTO) {
        service.createNotification(
                "Você recebeu um pix de " + pixKafkaDTO.value().toString(),
                pixKafkaDTO.destinationUserId()
        );
    }

}
