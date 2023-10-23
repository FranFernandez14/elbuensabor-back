package com.utn.elbuensabor.controllers.PedidosController;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import com.utn.elbuensabor.entities.pedidos.PedidoEstado;
import com.utn.elbuensabor.services.pedidos.PedidoEstadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedido/estados")
public class PedidoEstadoController extends BaseControllerImpl<PedidoEstado,PedidoEstadoServiceImpl> {
    /*@GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }*/

}