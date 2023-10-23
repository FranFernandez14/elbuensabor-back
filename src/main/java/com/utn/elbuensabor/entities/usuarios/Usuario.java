package com.utn.elbuensabor.entities.usuarios;

import com.utn.elbuensabor.entities.Base;
import jakarta.validation.constraints.NotNull;

public class Usuario extends Base {

    @NotNull
    private String username;
    @NotNull
    private String auth0id;

}
