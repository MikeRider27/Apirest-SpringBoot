package com.example.rest.service;

import com.example.rest.exception.ClienteNotFoundException;
import com.example.rest.model.Cliente;
import com.example.rest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public void updateCliente(Long id, Cliente clienteActualizar) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));

        cliente.setPersona(clienteActualizar.getPersona());
        cliente.setContrasena(clienteActualizar.getContrasena());
        cliente.setEstado(clienteActualizar.getEstado());

        clienteRepository.save(cliente);
    }

}
