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
        boolean existe = false;
        for (DetallePedido detalle: pedido.getDetalles()) {
            if (detalle.getProducto().getId()== detallePedidoDTO.getIdProducto()){
                detalle.setCantidad(detalle.getCantidad()+ detalle.getCantidad());
                detalle.setSubtotal(detalle.getSubtotal()+detalle.getProducto().getPrecioVenta());
                detalle.setSubtotalCosto(detalle.getSubtotalCosto()+detalle.getProducto().getCosto());
                pedido.setTotal(pedido.getTotal() + detalle.getProducto().getPrecioVenta());
                pedido.setTotalCosto(pedido.getTotalCosto() + detalle.getProducto().getCosto());
                existe = true;
                break;
            }
        }
        
        if (existe == false){
            Producto producto = productoService.findById(detallePedidoDTO.getIdProducto());
            DetallePedido detallePedido = DetallePedido.builder().
                    cantidad(1).
                    producto(producto).
                    subtotal(producto.getPrecioVenta()).
                    subtotalCosto(producto.getCosto()).
                    build();
            pedido.getDetalles().add(detallePedido);
        }
        pedidoRepository.save(pedido);
        return pedido;
    }

}
