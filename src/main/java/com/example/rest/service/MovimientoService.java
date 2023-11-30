package com.example.rest.service;

import com.example.rest.model.Movimiento;
import com.example.rest.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovimientoService {
    private final MovimientoRepository movimientoRepository;

    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    public Movimiento createMovimiento(Movimiento movimiento) {
        // Aquí puedes realizar validaciones o lógica de negocio antes de guardar el movimiento
        return movimientoRepository.save(movimiento);
    }

    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }

    public List<Movimiento> getMovimientosByFilter(Date fechaInicio, Date fechaFin, Long clienteId) {
        return movimientoRepository.findByFechaBetweenAndCuenta_ClienteId(fechaInicio, fechaFin, clienteId);
    }
}
