package com.example.rest.repository;

import com.example.rest.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    // Puedes añadir consultas específicas si es necesario
}
