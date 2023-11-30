package com.example.rest.controller;

import com.example.rest.model.Cuenta;
import com.example.rest.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }

    @GetMapping("/{id}")
    public Cuenta getCuentaById(@PathVariable Long id) {
        return cuentaService.getCuentaById(id);
    }

    @PostMapping
    public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta) {
        Cuenta createdCuenta = cuentaService.createCuenta(cuenta);
        return new ResponseEntity<>(createdCuenta, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteCuenta(@PathVariable Long id) {
        cuentaService.deleteCuenta(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuentaActualizar) {
        Cuenta cuentaActualizada = cuentaService.updateCuenta(id, cuentaActualizar);
        return new ResponseEntity<>(cuentaActualizada, HttpStatus.OK);
    }
}
