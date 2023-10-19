package com.utn.elbuensabor.services.impl.pedidos;

import com.utn.elbuensabor.entities.pedidos.PedidoEstado;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.pedidos.PedidoEstadoRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.pedidos.PedidoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoEstadoServiceImpl extends BaseServiceImpl<PedidoEstado, Long> implements PedidoEstadoService {

    @Autowired
    private PedidoEstadoRepository pedidoEstadoRepository;

    public PedidoEstadoServiceImpl(BaseRepository<PedidoEstado, Long> baseRepository, PedidoEstadoRepository pedidoEstadoRepository) {
        super(baseRepository);
        this.pedidoEstadoRepository = pedidoEstadoRepository;
    }
}
