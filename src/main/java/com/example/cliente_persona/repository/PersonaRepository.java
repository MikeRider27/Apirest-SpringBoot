package com.example.cliente_persona.repository;

import com.example.cliente_persona.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
