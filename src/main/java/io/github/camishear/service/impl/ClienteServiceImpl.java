package io.github.camishear.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.camishear.repository.ClienteRepository;
import io.github.camishear.repository.entity.Cliente;
import io.github.camishear.service.ClienteService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(Cliente cliente) {

        return null;
    }

    @Override
    public Optional<List<Cliente>> listar(String nome, int size, int page) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        // TODO Auto-generated method stub
        return null;
    }

}
