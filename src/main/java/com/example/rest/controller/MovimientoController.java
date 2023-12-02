package com.example.rest.controller;

import com.example.rest.exception.MovimientoNotFoundException;
import com.example.rest.exception.SaldoInsuficienteException;
import com.example.rest.model.Movimiento;
import com.example.rest.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    private final MovimientoService movimientoService;

    @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }

    @GetMapping("/{id}")
    public Movimiento getMovimientoById(@PathVariable Long id) {
        return movimientoService.getMovimientoById(id);
    }

    @ExceptionHandler(MovimientoNotFoundException.class)
    public ResponseEntity<String> handleMovimientoNotFoundException(MovimientoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<String> handleSaldoInsuficienteException(SaldoInsuficienteException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Movimiento> addMovimiento(@RequestBody Movimiento movimiento) {
        try {
            Movimiento nuevoMovimiento = movimientoService.addMovimiento(movimiento);
            return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
        } catch (SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 
            // Tipo de dato null, ya que no hay un cuerpo válido en caso de error
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); 
            // Tipo de dato null, ya que no hay un cuerpo válido en caso de error
        }
    }

}
