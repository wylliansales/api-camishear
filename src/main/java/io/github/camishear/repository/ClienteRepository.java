package io.github.camishear.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.camishear.repository.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
