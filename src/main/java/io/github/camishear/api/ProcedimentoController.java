package io.github.camishear.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.camishear.dto.prodecimento.ProcedimentoListRequestDto;
import io.github.camishear.dto.prodecimento.ProcedimentoListResponseDto;
import io.github.camishear.dto.prodecimento.ProcedimentoSalvarRequestDto;
import io.github.camishear.repository.entity.Procedimento;
import io.github.camishear.service.ProcedimentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

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
	})
	public void salvarProcecimento(@RequestBody @Valid ProcedimentoSalvarRequestDto dto) {
		procedimentoService.salvar(dto);
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
			@RequestBody ProcedimentoSalvarRequestDto dto) {
		procedimentoService.atualizar(id, dto);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Busca o procedimento por ID")
	@ApiResponses({
			@ApiResponse(code = 404, message = "Procedimento não foi encontrado"),
			@ApiResponse(code = 500, message = "Error Interno", response = Error.class)
	})
	public ProcedimentoListResponseDto buscarClientePorId(
			@ApiParam(value = "Id do cliente", example = "1") @PathVariable Integer id) {
		Procedimento procedimento = procedimentoService.buscarPorId(id);
		return ProcedimentoListResponseDto.builder()
				.id(procedimento.getId())
				.nome(procedimento.getNome())
				.valor(procedimento.getValor())
				.comissao(procedimento.getComissao())
				.build();
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("EndPoint que lista os procedimentos")
	public Page<ProcedimentoListResponseDto> listarProcedimentos(
			@RequestHeader @Valid ProcedimentoListRequestDto dto) {
		Page<Procedimento> procedimentos = procedimentoService
				.pesquisar(dto.getNome(), dto.getPage(), dto.getSize());

		return procedimentos.map(p -> ProcedimentoListResponseDto.builder()
				.id(p.getId())
				.nome(p.getNome())
				.valor(p.getValor())
				.comissao(p.getComissao())
				.build());
	}
}
