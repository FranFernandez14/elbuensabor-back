package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.repositories.productos.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class ProductoControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductoRepository productoRepository;
}
