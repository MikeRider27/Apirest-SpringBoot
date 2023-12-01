package com.example.rest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.Movimiento;
/*import com.example.rest.service.MovimientoService;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<List<Movimiento>> getReporte(
            @RequestParam(name = "fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam(name = "fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
            @RequestParam(name = "clienteId") Long clienteId) {
        
        List<Movimiento> movimientos = movimientoService.getMovimientosByFilter(fechaInicio, fechaFin, clienteId);
        return new ResponseEntity<>(movimientos, HttpStatus.OK);
    }
}*/
