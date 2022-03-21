package io.github.camishear.domain.repository;

import io.github.camishear.domain.entity.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer> {
}
