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

    @ExceptionHandler(MovimientoNotFoundException.class)
    public ResponseEntity<String> handleMovimientoNotFoundException(MovimientoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

  

    // Puedes agregar más métodos según sea necesario
}

