package io.github.mateusbosquetti.kafkapix.model.entity;

import io.github.mateusbosquetti.kafkapix.model.enums.PixStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID identificador;

    @ManyToOne
    private Key chaveOrigem;

    @ManyToOne
    private Key chaveDestino;

    @Column
    private BigDecimal valor;

    @Column
    private LocalDateTime dataTransferencia;

    @Column
    @Enumerated(EnumType.STRING)
    private PixStatus status;

    @PrePersist
    public void onPersist() {
        this.identificador = UUID.randomUUID();
        this.dataTransferencia = LocalDateTime.now();
    }


}
