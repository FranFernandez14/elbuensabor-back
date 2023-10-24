package com.utn.elbuensabor.services.pedidos;

import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.pedidos.PedidoRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }
   //Cambiar PedidoEstado
    @Override
    public List<Pedido> cambiarEstado(Long id, EstadoPedido estadoPedido) throws Exception{
        try{
            List<Pedido> pedido=pedidoRepository.cambiarEstado(id, estadoPedido);
            return pedido;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Pedido> buscar(Long id, List<EstadoPedido> estados, Pageable pageable) throws Exception{
        try{
            Page<Pedido> pedido=pedidoRepository.buscar(id,estados, pageable);
            return pedido;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
