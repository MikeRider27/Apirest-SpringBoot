package com.example.rest.exception;

public class MovimientoNotFoundException extends RuntimeException {
    public MovimientoNotFoundException(Long id) {
        super("Movimiento no encontrada con ID: " + id);
    }
}
