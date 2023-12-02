package com.example.rest;

import com.example.rest.model.Cliente;
import com.example.rest.repository.PersonaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//Descomentar lo que esta en /* */
/*
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteIntegrationTest {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddClienteIntegration() throws Exception {
        // Obtener una persona existente para la prueba (asegúrate de que exista en la base de datos)
        // Cambié el ID de 2L a 1L para usar un valor más común
        Long personaId = 1L;
        Cliente cliente = new Cliente();

        // Asegúrate de que la persona con el ID proporcionado exista en la base de datos
        cliente.setPersona(personaRepository.findById(personaId)
                .orElseThrow(() -> new RuntimeException("La persona con ID " + personaId + " no existe en la base de datos.")));

        cliente.setContrasena("123456");
        cliente.setEstado(true);

        // Realizar la solicitud HTTP simulada para agregar un cliente
        performRequest(cliente, status().isCreated());
    }

    private void performRequest(Cliente cliente) throws Exception {
        performRequest(cliente, status().isCreated());
    }

    private void performRequest(Cliente cliente, ResultMatcher expectedResult) throws Exception {
        // Convertir el objeto Cliente a formato JSON
        String clienteJson = objectMapper.writeValueAsString(cliente);

        // Realizar la solicitud HTTP simulada para agregar un cliente
        ResultActions resultActions = mockMvc.perform(post("/api/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clienteJson));

        // Verificar que la solicitud fue exitosa o generó el resultado esperado
        resultActions.andExpect(expectedResult);
    }
}
*/