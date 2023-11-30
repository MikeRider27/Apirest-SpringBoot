package com.example.rest.repository;

import com.example.rest.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByFechaBetweenAndCuenta_ClienteId(Date fechaInicio, Date fechaFin, Long clienteId);
}
