package br.com.una.ecoclean.ecocleanapi.model.service.impl;

import br.com.una.ecoclean.ecocleanapi.model.entities.Cliente;
import br.com.una.ecoclean.ecocleanapi.model.repositories.ClienteRepository;
import br.com.una.ecoclean.ecocleanapi.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public Cliente salvar(Cliente cliente) {
       return clienteRepository.save(cliente);
    }

    @Override
    public Cliente altera(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscaPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> todos() {
        return clienteRepository.findAll();
    }

    @Override
    public void removePorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
