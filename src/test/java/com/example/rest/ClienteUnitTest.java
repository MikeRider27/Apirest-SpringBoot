package com.example.rest;

import com.example.rest.model.Cliente;
import com.example.rest.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//Descomentar lo que esta en /* */
/*
@SpringBootTest
public class ClienteUnitTest {

    @Autowired
    private TestUtils testUtils;

    @Test
    public void testAddClienteUnit() {
        // Obtener un cliente utilizando el TestUtils
        Cliente cliente = testUtils.createCliente();

        // Asegurarse de que el cliente no sea nulo
        assertNotNull(cliente);

        // Asegurarse de que la persona en el cliente no sea nula
        assertNotNull(cliente.getPersona());

        // Puedes agregar más aserciones según sea necesario para verificar otras propiedades del cliente

        // Por ejemplo, si hay un campo específico que debe cumplir con ciertas condiciones:
        // assertTrue(cliente.getAlgunaPropiedad() > 0, "La propiedad 'algunaPropiedad' debe ser mayor que 0");

        // Agregar más aserciones según sea necesario
    }
}
*/