package io.github.mateusbosquetti.pixapi.model.dto;

import java.math.BigDecimal;

public record PixKafkaDTO(BigDecimal value, Long originUserId, Long destinationUserId) {
}
