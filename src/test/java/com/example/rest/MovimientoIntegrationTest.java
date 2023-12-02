package com.example.rest;

import com.example.rest.model.Movimiento;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovimientoIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddMovimientoIntegration() throws Exception {
        // Crear un objeto Movimiento para la prueba
        Movimiento movimiento = new Movimiento();
        movimiento.setFecha(new Date());
        movimiento.setValor(new BigDecimal("100.00")); // Ajusta según tus necesidades

        // Convertir el objeto Movimiento a formato JSON
        String movimientoJson = objectMapper.writeValueAsString(movimiento);

        // Realizar la solicitud HTTP simulada para agregar un movimiento
        ResultActions resultActions = mockMvc.perform(post("/api/movimientos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(movimientoJson));

        // Verificar que la solicitud fue exitosa (código 201)
        resultActions.andExpect(status().isCreated());
        
    }
 
}
