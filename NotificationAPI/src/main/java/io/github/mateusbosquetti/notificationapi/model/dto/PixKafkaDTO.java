package io.github.mateusbosquetti.notificationapi.model.dto;

import java.math.BigDecimal;

public record PixKafkaDTO(BigDecimal value, Long destinationUserId) {
}
