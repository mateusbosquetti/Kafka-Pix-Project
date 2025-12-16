package io.github.mateusbosquetti.kafkapix.service;

import io.github.mateusbosquetti.kafkapix.model.entity.Key;
import io.github.mateusbosquetti.kafkapix.repository.KeyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KeyService {

    private final KeyRepository repository;

    public Key findByKey(String key) {
        return this.repository.findByChave(key).orElseThrow(() -> new RuntimeException("Key não encontrada"));
    }


}
