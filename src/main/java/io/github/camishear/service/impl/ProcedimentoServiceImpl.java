package io.github.camishear.service.impl;

import io.github.camishear.domain.entity.Procedimento;
import io.github.camishear.domain.repository.ProcedimentoRepository;
import io.github.camishear.service.ProcedimentoService;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcedimentoServiceImpl implements ProcedimentoService {

    private final ProcedimentoRepository procedimentoRepository;

    @Override
    @Transactional
    public Procedimento salvar(Procedimento procedimento) {
        try {
            procedimentoRepository.save(procedimento);
        } catch (Exception ex) {
            log.error("Cadastro de Procedimento", ex);
        }
        return procedimento;
    }

    @Override
    public List<Procedimento> pesquisar(String nome, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return procedimentoRepository.findAll();
    }

    @Override
    public Procedimento atualizar(Procedimento procedimento) {
        return procedimentoRepository
                .findById(procedimento.getId())
                .map(proc -> {
                    return procedimentoRepository.save(proc);
                })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Procedimento não encontrato pelo ID informado"
                ));
    }
}