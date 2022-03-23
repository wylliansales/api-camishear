package io.github.camishear.api.controller;

import ch.qos.logback.core.pattern.Converter;
import io.github.camishear.api.dto.prodecimento.ProcedimentoListRequestDto;
import io.github.camishear.api.dto.prodecimento.ProcedimentoListResponseDto;
import io.github.camishear.api.dto.prodecimento.ProcedimentoSalvarRequestDto;
import io.github.camishear.domain.entity.Procedimento;
import io.github.camishear.service.ProcedimentoService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/procedimentos")
@Api("API contendo os endpoints de Prodecimentos")
public class ProcedimentoController {

    private final ProcedimentoService procedimentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "EndPoint responsável por salvar o procedimento")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Procedimento cadastrado com sucesso"),
            @ApiResponse(code = 400, message = "Procedimento não cadastrado, dados inválidos", response = Error.class),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")
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
    @ApiOperation(value = "EndPoint responsável por atualizar o procedimento")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Procedimento foi atualizado"),
            @ApiResponse(code = 404, message = "Procedimento não foi encontrado")
    })
    public void atualizarProcedimento(
            @ApiParam(value = "Id do procedimento", example = "1") @PathVariable Integer id,
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
    public Page<ProcedimentoListResponseDto> listarProcedimentos(
            @Valid ProcedimentoListRequestDto dto
            ) {
        Page<Procedimento> procedimentos =  procedimentoService
                .pesquisar(dto.getNome(), dto.getPage(), dto.getSize());

        return procedimentos.map( p -> {
            return ProcedimentoListResponseDto.builder()
                    .id(p.getId())
                    .nome(p.getNome())
                    .valor(p.getValor())
                    .comissao(p.getComissao())
                    .build();
        });
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
