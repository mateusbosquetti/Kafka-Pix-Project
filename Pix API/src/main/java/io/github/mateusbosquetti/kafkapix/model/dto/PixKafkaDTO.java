package io.github.mateusbosquetti.kafkapix.model.dto;

import java.math.BigDecimal;

public record PixKafkaDTO(BigDecimal value, Long destinationUserId) {
}
