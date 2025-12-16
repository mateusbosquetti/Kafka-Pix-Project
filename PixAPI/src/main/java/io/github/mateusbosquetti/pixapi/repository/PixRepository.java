package io.github.mateusbosquetti.pixapi.repository;

import io.github.mateusbosquetti.pixapi.model.entity.Pix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PixRepository extends JpaRepository<Pix, Long> {
}
