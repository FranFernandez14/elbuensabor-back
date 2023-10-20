package com.utn.elbuensabor.entities.productos;

import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rubro_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RubroInsumo extends Base {

    @ManyToOne()
    @JoinColumn(name = "id_rubro_padre")
    private RubroInsumo rubroPadre;


    @OneToMany(mappedBy = "rubroPadre")
    @Builder. Default
    private List<RubroInsumo> subRubro=new ArrayList<>();


    @OneToMany(mappedBy = "rubroInsumo", cascade = CascadeType.REFRESH)
    @Builder. Default
    private List<Insumo> insumos = new ArrayList();


}
