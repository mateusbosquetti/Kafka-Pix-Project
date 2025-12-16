package io.github.mateusbosquetti.pixapi.model.dto;

import java.math.BigDecimal;

public record PixRequestDTO (String chaveOrigem, String chaveDestino, BigDecimal valor) {
}
