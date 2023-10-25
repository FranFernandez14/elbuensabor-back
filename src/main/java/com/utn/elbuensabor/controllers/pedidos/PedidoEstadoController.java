package com.utn.elbuensabor.controllers.pedidos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import com.utn.elbuensabor.entities.pedidos.PedidoEstado;
import com.utn.elbuensabor.services.pedidos.PedidoEstadoServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos/pedidoEstado")
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