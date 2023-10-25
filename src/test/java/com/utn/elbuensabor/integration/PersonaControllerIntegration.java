package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.productos.Insumo;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.usuarios.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class PersonaControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaRepository personaRepository;



    @Test
    void testCambiarContraseña() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        persona.setApellido("Honguito");
        persona.setEmail("ph@mail.com");
        persona.setTelefono("12345678");
        persona.setPassword("abcd");
        personaRepository.save(persona);

        mockMvc.perform(put("/api/v1/usuarios/persona/cambiarContraseña")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, " +
                                "\"contraseñaActual\": \"abcd\", " +
                                "\"contraseñaNueva\": \"efgh\"}"))
                .andExpect(status().isOk());

    }


    @Test
    void testCambiarDatos() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        persona.setApellido("Honguito");
        persona.setEmail("ph@mail.com");
        persona.setTelefono("12345678");
        persona.setPassword("abcd");
        persona.setRol(Rol.CLIENTE);
        personaRepository.save(persona);

        mockMvc.perform(put("/api/v1/usuarios/persona/cambiarDatos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, " +
                                "\"nombre\": \"Pedro\", " +
                                "\"apellido\": \"Hongo\", " +
                                "\"email\": \"ph@mail.com\", " +
                                "\"telefono\": \"73482834\", " +
                                "\"rol\": \"ADMINISTRADOR\"}"))
                .andExpect(status().isOk());

    }

    @Test
    void testRanking() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        persona.setApellido("Honguito");
        persona.setEmail("ph@mail.com");
        persona.setTelefono("12345678");
        persona.setPassword("abcd");
        persona.setRol(Rol.CLIENTE);
        personaRepository.save(persona);

        mockMvc.perform(get("/api/v1/usuarios/persona/ranking")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("fechaInicio","2023-10-20")
                        .param("fechaFin","2023-10-30"))
                .andExpect(status().isOk());

    }
}
