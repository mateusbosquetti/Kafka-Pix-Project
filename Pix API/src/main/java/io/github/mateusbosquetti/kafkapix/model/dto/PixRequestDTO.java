package io.github.mateusbosquetti.kafkapix.model.dto;

import java.math.BigDecimal;

public record PixRequestDTO (String chaveOrigem, String chaveDestino, BigDecimal valor) {
}
