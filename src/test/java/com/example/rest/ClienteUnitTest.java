package com.example.rest;

import com.example.rest.model.Cliente;
import com.example.rest.model.Persona;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ClienteUnitTest {

    @Test
    public void testGettersAndSetters() {
        // Crear un objeto Persona para asociarlo al Cliente
        Persona persona = mock(Persona.class);

        // Crear un objeto Cliente para la prueba
        Cliente cliente = new Cliente(persona, true);
        cliente.setId(1L);
        cliente.setContrasena("password");

        // Verificar que los métodos get devuelvan los valores esperados
        assertEquals(1L, cliente.getId());
        assertEquals(persona, cliente.getPersona());
        assertEquals("password", cliente.getContrasena());
        assertEquals(true, cliente.getEstado());
    }


    // Ejemplo de una prueba adicional
    @Test
    public void testEstadoInicial() {
        // Crear un objeto Persona para asociarlo al Cliente
        Persona persona = mock(Persona.class);

        // Crear un objeto Cliente para la prueba
        Cliente cliente = new Cliente(persona, true);

        // Verificar que el estado inicial es el esperado
        assertEquals(true, cliente.getEstado());
    }
}

