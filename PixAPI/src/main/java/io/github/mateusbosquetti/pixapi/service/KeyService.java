package io.github.mateusbosquetti.pixapi.service;

import io.github.mateusbosquetti.pixapi.model.entity.Key;
import io.github.mateusbosquetti.pixapi.repository.KeyRepository;
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
