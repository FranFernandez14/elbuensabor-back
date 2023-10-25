package com.utn.elbuensabor.controllers.usuarios;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import com.utn.elbuensabor.dtos.CambiarContraseñaDTO;
import com.utn.elbuensabor.dtos.CambiarDatosDTO;
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
@RequestMapping(path = "api/v1/usuarios/persona")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {
    @PutMapping("/cambiarContraseña")
    public ResponseEntity<?> search(@RequestBody CambiarContraseñaDTO cambiarContraseñaDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarContrasena(cambiarContraseñaDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }

    @PutMapping("/cambiarDatos")
    public ResponseEntity<?> search(@RequestBody CambiarDatosDTO cambiarDatosDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarDatos(cambiarDatosDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }
    @GetMapping("/ranking")
    public ResponseEntity<?> search(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam  String ordenar, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.ranking(fechaInicio,fechaFin,ordenar, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}