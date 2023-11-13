package com.utn.elbuensabor.services.pedidos;

import com.utn.elbuensabor.dtos.CambiarEstadoDTO;
import com.utn.elbuensabor.dtos.DetallePedidoDTO;
import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.pedidos.DetallePedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.entities.productos.Producto;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.pedidos.PedidoRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoService productoService;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }
   //Cambiar estado
    @Override
    public Pedido cambiarEstado(CambiarEstadoDTO cambiarEstadoDTO) throws Exception{
        try{
            Pedido pedido = pedidoRepository.findById(cambiarEstadoDTO.getIdPedido()).get();

            pedido.setEstadoActual(cambiarEstadoDTO.getEstadoPedido());

            pedidoRepository.save(pedido);

            return pedido;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Pedido> buscar(List<EstadoPedido> estados, Pageable pageable) throws Exception{
        try{
            Page<Pedido> pedido=pedidoRepository.buscar(estados, pageable);
            return pedido;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Pedido agregarDetalle(DetallePedidoDTO detallePedidoDTO) throws Exception {
        Pedido pedido = pedidoRepository.getReferenceById(detallePedidoDTO.getIdPedido());
        Producto producto = productoService.findById(detallePedidoDTO.getIdProducto());
        double cant = (double) detallePedidoDTO.getCantidad();
        DetallePedido detallePedido = DetallePedido.builder().
                cantidad(detallePedidoDTO.getCantidad()).
                producto(producto).
                subtotal(cant*producto.getPrecioVenta()).
                subtotalCosto(cant*producto.getCosto()).
                build();
        pedido.getDetalles().add(detallePedido);
        pedido.setTotal(pedido.getTotal() + detallePedido.getSubtotal());
        pedido.setTotalCosto(pedido.getTotalCosto() + detallePedido.getSubtotalCosto());
        pedidoRepository.save(pedido);
        return pedido;
    }

}
