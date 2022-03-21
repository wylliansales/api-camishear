package io.github.camishear.api.controller;

import io.github.camishear.api.dto.prodecimento.ProcedimentoListRequestDto;
import io.github.camishear.api.dto.prodecimento.ProcedimentoListResponseDto;
import io.github.camishear.api.dto.prodecimento.ProcedimentoSalvarRequestDto;
import io.github.camishear.domain.entity.Procedimento;
import io.github.camishear.service.ProcedimentoService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/procedimentos")
@Api("API contento os endpoints de Prodecimentos")
public class ProcedimentoController {

    private final ProcedimentoService procedimentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("EndPoint responsável por salvar o procedimento")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Procedimento cadastrado com sucesso"),
            @ApiResponse(code = 400, message = "Procedimento não cadastrado, dados inválidos", response = Error.class)
    })
    public void salvarProcecimento(@RequestBody @Valid ProcedimentoSalvarRequestDto dto) {
        Procedimento procedimento = Procedimento
                .builder()
                .nome(dto.getNome())
                .valor(dto.getValor())
                .comissao(dto.getComissao())
                .build();
        procedimentoService.salvar(procedimento);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("EndPoint responsável por atualizar o procedimento")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Procedimento foi atualizado"),
            @ApiResponse(code = 404, message = "Procedimento não foi encontrado")
    })
    public void atualizarProcedimento(
            @ApiParam("Id do procedimento") @PathVariable Integer id,
            @RequestBody ProcedimentoSalvarRequestDto dto
    ) {
        Procedimento procedimento = Procedimento
                .builder()
                .id(id)
                .nome(dto.getNome())
                .valor(dto.getValor())
                .comissao(dto.getComissao())
                .build();
        procedimentoService.atualizar(procedimento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("EndPoint que lista os procedimentos")
    public List<ProcedimentoListResponseDto> listarProcedimentos(
            @RequestParam ProcedimentoListRequestDto dto
            ) {
        List<Procedimento> procedimentos =  procedimentoService
                .pesquisar(dto.getNome(), dto.getPage(), dto.getSize());

        return procedimentos
                .stream()
                .map(procedimento -> converterToProcedimento(procedimento))
                .collect(Collectors.toList());
    }

    private ProcedimentoListResponseDto converterToProcedimento(Procedimento procedimento) {
        return ProcedimentoListResponseDto
                .builder()
                .id(procedimento.getId())
                .nome(procedimento.getNome())
                .valor(procedimento.getValor())
                .comissao(procedimento.getComissao())
                .build();
    }

}
