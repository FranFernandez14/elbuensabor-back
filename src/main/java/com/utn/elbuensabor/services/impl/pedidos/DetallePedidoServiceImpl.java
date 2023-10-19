package com.utn.elbuensabor.services.impl.pedidos;

import com.utn.elbuensabor.entities.pedidos.DetallePedido;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.pedidos.DetallePedidoRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.pedidos.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoRepository detallePedidoRepository) {
        super(baseRepository);
        this.detallePedidoRepository = detallePedidoRepository;
    }
}
