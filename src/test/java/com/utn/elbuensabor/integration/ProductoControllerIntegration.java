package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.facturacion.DetalleFactura;
import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.entities.productos.Producto;
import com.utn.elbuensabor.entities.productos.RubroProducto;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.facturacion.DetalleFacturaRepository;
import com.utn.elbuensabor.repositories.facturacion.FacturaRepository;
import com.utn.elbuensabor.repositories.productos.ProductoRepository;
import com.utn.elbuensabor.repositories.productos.RubroProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class ProductoControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private RubroProductoRepository rubroProductoRepository;


    @Test
    void testPorRubro() throws Exception {
        Producto producto = new Producto();
        RubroProducto rubroProducto = new RubroProducto();
        rubroProducto.setDenominacion("RP1");


        producto.setRubroProducto(rubroProducto);

        rubroProductoRepository.save(rubroProducto);
        productoRepository.save(producto);


        mockMvc.perform(get("/api/v1/productos/producto/porRubro")
                        .param("page", "0")
                        .param("size", "5")
                        .param("denominacion", "RP1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].rubroProducto.denominacion", is("RP1")));

    }

    @Test
    void testBuscar() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("P1");

        productoRepository.save(producto);


        mockMvc.perform(get("/api/v1/productos/producto/buscar")
                        .param("page", "0")
                        .param("size", "5")
                        .param("denominacion", "P1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].denominacion", is("P1")));

    }


    @Test
    void testRanking() throws Exception {
        Producto producto = new Producto();
        RubroProducto rubroProducto = new RubroProducto();
        rubroProducto.setDenominacion("RP1");
        Factura factura = new Factura();
        factura.setFechaFacturacion((new SimpleDateFormat("yyyy-MM-dd")).parse("2023-10-25"));
        DetalleFactura detalleFactura = new DetalleFactura();

        producto.setRubroProducto(rubroProducto);
        detalleFactura.setFactura(factura);
        detalleFactura.setProducto(producto);

        facturaRepository.save(factura);
        rubroProductoRepository.save(rubroProducto);
        productoRepository.save(producto);
        detalleFacturaRepository.save(detalleFactura);


        mockMvc.perform(get("/api/v1/productos/producto/ranking")
                        .param("fechaInicio", "2023-10-24")
                        .param("fechaHasta", "2023-10-26")
                        .param("page", "0")
                        .param("size", "5")
                        .param("denominaciones", "RP1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
