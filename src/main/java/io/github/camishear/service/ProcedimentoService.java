package io.github.camishear.service;

import org.springframework.data.domain.Page;

import io.github.camishear.dto.prodecimento.ProcedimentoSalvarRequestDto;
import io.github.camishear.repository.entity.Procedimento;

public interface ProcedimentoService {

    /**
     * Realiza o cadastro do procedimento.
     * @param procedimentoSalvarRequestDto
     * @return
     */
    Procedimento salvar(ProcedimentoSalvarRequestDto procedimentoSalvarRequestDto);

    /**
     * Listar os procedimento paginada, realiza o filtro pelo nome.
     * @param nome
     * @param page
     * @param size
     * @return
     */
    Page<Procedimento> pesquisar(String nome, int page, int size);

    /**
     *  Atualiza o procedimento conforme os parametros de entrada
     * @param id
     * @param procedimentoSalvarRequestDto
     * @return
     */
    Procedimento atualizar(Integer id, ProcedimentoSalvarRequestDto procedimentoSalvarRequestDto);
    
    /**
     * Buscar procedimento por id
     * @param id
     * @return
     */
    Procedimento buscarPorId(Integer id);
}
