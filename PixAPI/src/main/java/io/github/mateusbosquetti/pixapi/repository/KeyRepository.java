package io.github.mateusbosquetti.pixapi.repository;

import io.github.mateusbosquetti.pixapi.model.entity.Key;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeyRepository extends JpaRepository<Key, Long> {
    Optional<Key> findByChave(String chave);
}
