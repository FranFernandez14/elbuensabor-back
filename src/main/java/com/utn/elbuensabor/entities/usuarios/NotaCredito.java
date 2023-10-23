package com.utn.elbuensabor.entities.usuarios;

import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "nota_credito")
@Builder
public class NotaCredito extends Base {

    @NotNull
    private double monto;

    @ManyToOne
    private Persona cliente;


}
