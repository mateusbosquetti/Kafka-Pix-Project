package io.github.mateusbosquetti.kafkapix.repository;

import io.github.mateusbosquetti.kafkapix.model.entity.Key;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeyRepository extends JpaRepository<Key, Long> {
    Optional<Key> findByChave(String chave);
}
