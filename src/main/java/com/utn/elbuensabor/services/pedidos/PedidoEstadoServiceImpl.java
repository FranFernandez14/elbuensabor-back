package com.utn.elbuensabor.services.pedidos;

import com.utn.elbuensabor.entities.pedidos.PedidoEstado;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.pedidos.PedidoEstadoRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoEstadoServiceImpl extends BaseServiceImpl<PedidoEstado, Long> implements PedidoEstadoService {

    @Autowired
    private PedidoEstadoRepository pedidoEstadoRepository;

    public PedidoEstadoServiceImpl(BaseRepository<PedidoEstado, Long> baseRepository, PedidoEstadoRepository pedidoEstadoRepository) {
        super(baseRepository);
        this.pedidoEstadoRepository = pedidoEstadoRepository;
    }


}
