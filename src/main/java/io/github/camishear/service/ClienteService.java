package io.github.camishear.service;

import java.util.List;
import java.util.Optional;

import io.github.camishear.repository.entity.Cliente;

public interface ClienteService {

    /**
     *  Cadastra o cliente na base de dados
     * @param cliente
     * @return
     */
    Cliente salvar(Cliente cliente);

    /**
     * Lista todos os cliente ou filtra pelo nome
     * @param nome
     * @param size
     * @param page
     * @return
     */
    Optional<List<Cliente>> listar(String nome, int size, int page);

    /**
     * Atualiza os dados do cliente
     * @param cliente
     * @return
     */
    Cliente atualizar(Cliente cliente);

}
