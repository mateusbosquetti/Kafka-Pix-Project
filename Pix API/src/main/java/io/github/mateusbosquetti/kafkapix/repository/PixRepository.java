package io.github.mateusbosquetti.kafkapix.repository;

import io.github.mateusbosquetti.kafkapix.model.entity.Pix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PixRepository extends JpaRepository<Pix, Long> {
}
