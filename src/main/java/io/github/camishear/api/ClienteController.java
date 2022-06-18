package io.github.camishear.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.camishear.dto.cliente.ClienteRequestDto;
import io.github.camishear.repository.entity.Cliente;
import io.github.camishear.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/clientes")
@Api("Api contendo endpoins de clientes")

public class ClienteController {

	private final ClienteService clienteService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "EndPoint responsavel por cadastrar o cliente")
	public void salvarCliente(@RequestBody @Valid ClienteRequestDto dto) {
		clienteService.salvar(Cliente.builder().nome(dto.getNome()).telefone(dto.getTelefone()).build());
	}
}
