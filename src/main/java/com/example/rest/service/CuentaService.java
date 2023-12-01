package com.example.rest.service;

import com.example.rest.model.Cuenta;
import com.example.rest.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta getCuentaById(Long id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada con ID: " + id));
    }

    public Cuenta createCuenta(Cuenta cuenta) {
        // Puedes realizar validaciones antes de guardar
        return cuentaRepository.save(cuenta);
    }

    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }

    public Cuenta updateCuenta(Long id, Cuenta cuentaActualizar) {
        Cuenta cuentaExistente = getCuentaById(id);

        // Actualizar los campos según sea necesario
        cuentaExistente.setNumeroCuenta(cuentaActualizar.getNumeroCuenta());
        cuentaExistente.setTipoCuenta(cuentaActualizar.getTipoCuenta());
        cuentaExistente.setSaldoInicial(cuentaActualizar.getSaldoInicial());
        cuentaExistente.setEstado(cuentaActualizar.getEstado());

        // Actualizar el cliente asociado si es necesario
        cuentaExistente.setCliente(cuentaActualizar.getCliente());

        return cuentaRepository.save(cuentaExistente);
    }

    public Cuenta actualizarCuenta(Cuenta cuenta) {
        // Obtener la cuenta existente por ID
        Cuenta cuentaExistente = getCuentaById(cuenta.getId());

        // Actualizar los campos según sea necesario
        cuentaExistente.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaExistente.setTipoCuenta(cuenta.getTipoCuenta());
        cuentaExistente.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaExistente.setEstado(cuenta.getEstado());

        // Actualizar el cliente asociado si es necesario
        cuentaExistente.setCliente(cuenta.getCliente());

        return cuentaRepository.save(cuentaExistente);
    }
}
