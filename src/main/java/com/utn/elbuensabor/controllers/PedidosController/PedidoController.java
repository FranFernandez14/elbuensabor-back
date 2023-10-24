package com.utn.elbuensabor.controllers.PedidosController;

import com.utn.elbuensabor.controllers.BaseControllerImpl;

import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.services.pedidos.PedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {
    @PutMapping("/cambiarEstado")
    public ResponseEntity<?> search(@RequestParam Long id, EstadoPedido estadoPedido) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarEstado(id,estadoPedido));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> search(@RequestParam Long id, List<EstadoPedido> estados, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar(id, estados, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}