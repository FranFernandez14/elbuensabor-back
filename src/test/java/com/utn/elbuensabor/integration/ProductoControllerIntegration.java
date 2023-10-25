package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.productos.*;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.productos.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class ProductoControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductoRepository productoRepository;
    @Test
    void testSave() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Pizza");
        producto.setDescripcion("Descripcion de un pizza");
        producto.setPrecioVenta(new BigDecimal(2000.00));


        mockMvc.perform(post("/api/v1/productos/producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        //Esto convierte el producto a Json
                        .content(asJsonString(producto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.denominacion", is("Pizza")))
                .andExpect(jsonPath("$.descripcion", is("Descripcion de un pizza")));
    }
    @Test
    void testUpdate() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Pizza");
        producto.setDescripcion("Descripcion de un pizza");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        // Guardar el producto en la base de datos
        Producto saveProducto = productoRepository.save(producto);

        // Actualizar los datos del producto
        saveProducto.setDenominacion("Hamburguesa");
        saveProducto.setDescripcion("Descripcion de un Hamburguesa");
        saveProducto.setPrecioVenta(new BigDecimal(1800));


        mockMvc.perform(put("/api/v1/productos/producto/{id}", saveProducto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(saveProducto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.denominacion", is("Hamburguesa")))
                .andExpect(jsonPath("$.descripcion", is("Descripcion de un Hamburguesa")));
    }
    @Test
    void testDelete() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Pizza");
        producto.setDescripcion("Descripcion de una Pizza");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        // Guardar la persona en la base de datos
        Producto saveProducto = productoRepository.save(producto);

        // Eliminar la persona de la base de datos
        mockMvc.perform(delete("/api/v1/productos/producto/{id}", saveProducto.getId()))
                .andExpect(status().isNoContent());

        // Verificar que la persona haya sido eliminada
        mockMvc.perform(get("/api/v1/productos/producto/{id}", saveProducto.getId()))
                .andExpect(status().isNotFound());
    }
    @Test
    void testGetOne() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Fideos");
        producto.setDescripcion("Descripcion de unos fideos");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        productoRepository.save(producto);

        mockMvc.perform(get("/api/v1/productos/producto/{id}",producto.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.denominacion", is("Fideos")))
                .andExpect(jsonPath("$.descripcion", is("Descripcion de unos fideos")));

    }
    @Test
    void testGetAll() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Fideos");
        producto.setDescripcion("Descripcion de unos fideos");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        Producto producto2 = new Producto();
        producto2.setDenominacion("Nada");
        producto2.setDescripcion("Descripcion de nada");
        producto2.setPrecioVenta(new BigDecimal(2000.00));

        productoRepository.save(producto);
        productoRepository.save(producto2);

        mockMvc.perform(get("/api/v1/productos/producto"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].denominacion", is("Fideos")))
                .andExpect(jsonPath("$[1].descripcion", is("Descripcion de unos fideos")))
                .andExpect(jsonPath("$[2].denominacion", is("Nada")))
                .andExpect(jsonPath("$[2].descripcion", is("Descripcion de nada")));
    }
    @Test
    void testGetAllWithPageable() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Fideos");
        producto.setDescripcion("Descripcion de unos fideos");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        Producto producto2 = new Producto();
        producto2.setDenominacion("Nada");
        producto2.setDescripcion("Descripcion de nada");
        producto2.setPrecioVenta(new BigDecimal(2000.00));

        productoRepository.save(producto);
        productoRepository.save(producto2);

        mockMvc.perform(get("/api/v1/productos/producto/paged")
                        .param("page", "0")
                        .param("size", "1")
                        .param("sort", "denominacion,asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].denominacion", is("Fideos")))
                .andExpect(jsonPath("$.content[0].descripcion", is("Descripcion de unos fideos")));
    }
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}