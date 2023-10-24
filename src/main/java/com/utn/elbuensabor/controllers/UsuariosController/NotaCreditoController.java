package com.utn.elbuensabor.controllers.UsuariosController;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import com.utn.elbuensabor.entities.usuarios.NotaCredito;
import com.utn.elbuensabor.services.usuarios.NotaCreditoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/notasCredito")
public class NotaCreditoController extends BaseControllerImpl<NotaCredito, NotaCreditoServiceImpl> {
    @GetMapping("/movimientos")
    public ResponseEntity<?> search(@RequestParam Date fechaDesde, Date fechaHasta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.movimientos(fechaDesde,fechaHasta));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}

