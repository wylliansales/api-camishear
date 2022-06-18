package io.github.camishear.service;

import java.util.List;
import java.util.Optional;

import io.github.camishear.repository.entity.Atendimento;

public interface AtendimentoService {

    /**
     * Cadastra o atendimento na base de dados
     * @param atendimento
     * @return
     */
    Atendimento salvar(Atendimento atendimento);

    /**
     * Listar todos os atenidmento, ou filtra pelos parametros do atendimento.
     * @param atendimento
     * @param size
     * @param page
     * @return
     */
    Optional<List<Atendimento>> listar(Atendimento atendimento, int size, int page);


}
