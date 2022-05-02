package io.github.camishear.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.camishear.repository.entity.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer> {
}
