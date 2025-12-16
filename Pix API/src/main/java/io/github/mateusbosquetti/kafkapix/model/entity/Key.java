package io.github.mateusbosquetti.kafkapix.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Key {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String chave;
    @Column()
    private Long userId;

}
