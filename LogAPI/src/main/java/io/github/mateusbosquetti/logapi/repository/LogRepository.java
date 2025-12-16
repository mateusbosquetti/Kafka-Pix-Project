package io.github.mateusbosquetti.logapi.repository;

import io.github.mateusbosquetti.logapi.model.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}