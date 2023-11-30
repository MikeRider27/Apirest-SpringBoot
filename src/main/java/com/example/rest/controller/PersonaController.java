package com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.rest.exception.PersonaNotFoundException;
import com.example.rest.model.Persona;
import com.example.rest.service.PersonaService;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
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
    public ResponseEntity<String> createPersona(@RequestBody Persona persona) {
        try {
            Persona nuevaPersona = personaService.createPersona(persona);
            return new ResponseEntity<>("Persona creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la persona: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable Long id) {
        try {
            personaService.deletePersona(id);
            return new ResponseEntity<>("Persona eliminada exitosamente", HttpStatus.OK);
        } catch (PersonaNotFoundException e) {
            return new ResponseEntity<>("Error al eliminar la persona: " + e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno al eliminar la persona", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePersona(@PathVariable Long id, @RequestBody Persona personaActualizar) {
        try {
            personaService.updatePersona(id, personaActualizar);
            return new ResponseEntity<>("Persona actualizada exitosamente", HttpStatus.OK);
        } catch (PersonaNotFoundException ex) {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la persona: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<String> handlePersonaNotFoundException(PersonaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
