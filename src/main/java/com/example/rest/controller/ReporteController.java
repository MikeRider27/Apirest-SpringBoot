package com.example.rest.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.MovimientoDto;
import com.example.rest.model.Movimiento;
import com.example.rest.service.MovimientoService;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<List<MovimientoDto>> getMovimientosByFilter(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
            @RequestParam Long clienteId) {

        List<Movimiento> movimientos = movimientoService.getMovimientosByFilter(fechaInicio, fechaFin, clienteId);

        List<MovimientoDto> movimientoDtos = movimientos.stream()
                .map(this::mapToMovimientoDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(movimientoDtos, HttpStatus.OK);
    }

    private MovimientoDto mapToMovimientoDto(Movimiento movimiento) {
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(movimiento.getFecha());
        String clienteNombre = movimiento.getCuenta().getCliente().getPersona().getNombre();
        String numeroCuenta = movimiento.getCuenta().getNumeroCuenta();
        String tipoCuenta = movimiento.getCuenta().getTipoCuenta();
        BigDecimal saldoInicial = movimiento.getCuenta().getSaldoInicial();
        boolean estado = movimiento.getCuenta().getEstado();
        BigDecimal valorMovimiento = movimiento.getValor();
        BigDecimal saldoDisponible = movimiento.getSaldo();

        return new MovimientoDto(fecha, clienteNombre, numeroCuenta, tipoCuenta, saldoInicial, estado, valorMovimiento, saldoDisponible);
    }
}

