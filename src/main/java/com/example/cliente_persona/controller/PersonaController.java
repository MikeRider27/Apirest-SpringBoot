package com.example.cliente_persona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cliente_persona.exception.PersonaNotFoundException;
import com.example.cliente_persona.model.Persona;
import com.example.cliente_persona.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id);
    }

    @PostMapping
    public Persona savePersona(@RequestBody Persona persona) {
        return personaService.savePersona(persona);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaActualizar) {
        Persona personaActualizada = personaService.updatePersona(id, personaActualizar);
        return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
    }

    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<String> handlePersonaNotFoundException(PersonaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
