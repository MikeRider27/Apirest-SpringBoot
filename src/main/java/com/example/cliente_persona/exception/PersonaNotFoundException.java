package com.example.cliente_persona.exception;

public class PersonaNotFoundException extends RuntimeException {
    public PersonaNotFoundException(Long id) {
        super("Persona no encontrada con ID: " + id);
    }
}
