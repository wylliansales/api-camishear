package io.github.camishear.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import io.github.camishear.constants.Constants;
import io.github.camishear.dto.prodecimento.ProcedimentoSalvarRequestDto;
import io.github.camishear.repository.ProcedimentoRepository;
import io.github.camishear.repository.entity.Procedimento;
import io.github.camishear.service.ProcedimentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcedimentoServiceImpl implements ProcedimentoService {

    private final ProcedimentoRepository procedimentoRepository;

    @Override
    @Transactional
    public Procedimento salvar(ProcedimentoSalvarRequestDto procedimentoSalvarRequestDto) {
        Procedimento procedimento = null;
        try {
            procedimento = Procedimento
                .builder()
                .nome(procedimentoSalvarRequestDto.getNome())
                .valor(procedimentoSalvarRequestDto.getValor())
                .comissao(procedimentoSalvarRequestDto.getComissao())
                .build();
            procedimentoRepository.save(procedimento);
        } catch (Exception ex) {
            log.error(String.format(Constants.LOG_ERROR_PREFIX, ex.getMessage()), ex);
        }
        return procedimento;
    }

    @Override
    public Page<Procedimento> pesquisar(String nome, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
        return procedimentoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Procedimento atualizar(Integer id, ProcedimentoSalvarRequestDto dto) {
        Procedimento procedimento = Procedimento
                .builder()
                .id(id)
                .nome(dto.getNome())
                .valor(dto.getValor())
                .comissao(dto.getComissao())
                .build();

        return procedimentoRepository
                .findById(procedimento.getId())
                .map(procedimentoRepository::save)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Procedimento não encontrato pelo NOME informado"));
    }

    @Override
    public Procedimento buscarPorId(Integer id) {
        return procedimentoRepository.findById(id)
                .map(procedimento -> procedimento)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Procedimento não encontrato por ID"));

    }
}
