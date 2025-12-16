package io.github.mateusbosquetti.logapi.service;

import io.github.mateusbosquetti.logapi.model.entity.Log;
import io.github.mateusbosquetti.logapi.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogService {

    private final LogRepository repository;

    public Log createLog (String message) {
        Log log = Log.builder()
                .message(message)
                .build();
        return this.repository.save(log);
    }

}
