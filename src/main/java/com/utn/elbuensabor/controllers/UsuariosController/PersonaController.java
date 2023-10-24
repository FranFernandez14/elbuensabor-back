package com.utn.elbuensabor.controllers.UsuariosController;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import com.utn.elbuensabor.entities.enums.Rol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.services.usuarios.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {
    @PutMapping("/cambiarContrasena")
    public ResponseEntity<?> search(@RequestParam Long id,String contrasenaNueva) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarContrasena(id,contrasenaNueva));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }

    @PutMapping("/cambiarDatos")
    public ResponseEntity<?> search(@RequestParam Long id, String nombre, String apellido, String telefono, Rol rol, String email) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarDatos(id,nombre,apellido,telefono,rol,email));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }
    @GetMapping("/ranking")
    public ResponseEntity<?> search(@RequestParam Date fechaInicio, Date fechaFin, String ordenar, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.ranking(fechaInicio,fechaFin,ordenar, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}