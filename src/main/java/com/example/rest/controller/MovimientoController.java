package com.example.rest.controller;

import com.example.rest.exception.MovimientoNotFoundException;
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

    @PostMapping
    public ResponseEntity<Movimiento> addMovimiento(@RequestBody Movimiento movimiento) {
        try {
            return new ResponseEntity<>(movimientoService.addMovimiento(movimiento), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Puedes agregar más métodos según sea necesario
}

