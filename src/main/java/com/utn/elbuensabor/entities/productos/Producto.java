package com.utn.elbuensabor.entities.productos;

import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Producto extends Base {

    @NotNull
    private String denominacion;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_rubro_producto")
    private RubroProducto rubroProducto;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_producto")
    private Receta receta;

}
