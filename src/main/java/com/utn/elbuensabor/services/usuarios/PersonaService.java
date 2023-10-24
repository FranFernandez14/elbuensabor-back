package com.utn.elbuensabor.services.usuarios;

import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PersonaService extends BaseService<Persona,Long> {
    List<Persona> cambiarContrasena (Long id,String contrasenaNueva) throws Exception;
    List<Persona> cambiarDatos (Long id, String nombre, String apellido, String telefono, Rol rol,String email ) throws Exception;
    Page<Persona> ranking (Date fechaInicio, Date fechaFin, String ordenar, Pageable pageable) throws Exception;

}
