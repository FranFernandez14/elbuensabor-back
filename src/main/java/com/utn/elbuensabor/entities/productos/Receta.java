package com.utn.elbuensabor.entities.productos;

import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "receta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Receta extends Base {

    @NotNull
    @OneToMany(mappedBy = "id_producto")
    private List<DetalleReceta> receta = new ArrayList();

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

}
