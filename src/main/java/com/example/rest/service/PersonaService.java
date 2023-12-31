package com.example.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.exception.PersonaNotFoundException;
import com.example.rest.model.Persona;
import com.example.rest.repository.PersonaRepository;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException(id));
    }

    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    public Persona updatePersona(Long id, Persona personaActualizar) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(personaActualizar.getNombre());
                    persona.setEdad(personaActualizar.getEdad());
                    persona.setGenero(personaActualizar.getGenero());
                    persona.setDireccion(personaActualizar.getDireccion());
                    persona.setTelefono(personaActualizar.getTelefono());

                    // Otros campos que desees actualizar
                    return personaRepository.save(persona);
                })
                .orElseThrow(() -> new PersonaNotFoundException(id));
    }
}
