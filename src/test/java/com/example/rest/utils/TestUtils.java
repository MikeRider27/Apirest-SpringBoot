package com.example.rest.utils;

import com.example.rest.model.Cliente;
import com.example.rest.model.Persona;
import com.example.rest.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUtils {

    @Autowired
    private PersonaRepository personaRepository;

    public Cliente createCliente() {
        Cliente cliente = new Cliente();
        Persona persona = personaRepository.findById(2L).orElse(null); // Asume que tienes un método findById en PersonaRepository
        cliente.setPersona(persona);
        cliente.setContrasena("123456");
        cliente.setEstado(true);
        return cliente;
    }
}
