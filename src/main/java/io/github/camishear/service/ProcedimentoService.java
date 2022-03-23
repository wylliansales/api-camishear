package io.github.camishear.service;

import io.github.camishear.domain.entity.Procedimento;
import org.springframework.data.domain.Page;

public interface ProcedimentoService {
    /**
     * Realiza o cadastro do procedimento.
     * @param procedimento
     * @return
     */
    Procedimento salvar(Procedimento procedimento);

    /**
     * Listar os procedimento paginada, realiza o filtro pelo nome.
     * @param nome
     * @param page
     * @param size
     * @return
     */
    Page<Procedimento> pesquisar(String nome, int page, int size);

    /**
     * Atualiza o procedimento conforme os parametros de entrada
     * @param procedimento
     * @return
     */
    Procedimento atualizar(Procedimento procedimento);

}
