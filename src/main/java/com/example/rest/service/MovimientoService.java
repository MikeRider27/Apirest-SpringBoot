package com.example.rest.service;

import com.example.rest.exception.MovimientoNotFoundException;
import com.example.rest.exception.SaldoInsuficienteException;
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

    public Movimiento getMovimientoById(Long id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() -> new MovimientoNotFoundException(id));
    }

    public Movimiento addMovimiento(Movimiento movimiento) {
        if (movimiento == null || movimiento.getCuenta() == null) {
            throw new IllegalArgumentException("Movimiento o cuenta no pueden ser nulos");
        }
        return movimientoRepository.save(movimiento);
    }


/*
   public Movimiento addMovimiento(Movimiento movimiento) {
    if (movimiento == null || movimiento.getCuenta() == null) {
        throw new IllegalArgumentException("Movimiento o cuenta no pueden ser nulos");
    }

    if (movimiento.getCuenta().getSaldoInicial() + movimiento.getValor() < 0) {
        throw new SaldoInsuficienteException("Saldo no disponible");
    } else {
        movimiento.getCuenta().setSaldo(movimiento.getCuenta().getSaldo() + movimiento.getValor());
    }
    return movimientoRepository.save(movimiento);       
}*/

  

    public List<Movimiento> getMovimientosByFilter(Date fechaInicio, Date fechaFin, Long clienteId) {
        return movimientoRepository.findByFechaBetweenAndCuenta_ClienteId(fechaInicio, fechaFin, clienteId);
    }
}
