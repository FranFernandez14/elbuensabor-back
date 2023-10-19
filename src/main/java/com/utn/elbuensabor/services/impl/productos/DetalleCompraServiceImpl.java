package com.utn.elbuensabor.services.impl.productos;

import com.utn.elbuensabor.entities.productos.DetalleCompra;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.DetalleCompraRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleCompraServiceImpl extends BaseServiceImpl<DetalleCompra, Long> implements DetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    public DetalleCompraServiceImpl(BaseRepository<DetalleCompra, Long> baseRepository, DetalleCompraRepository detalleCompraRepository) {
        super(baseRepository);
        this.detalleCompraRepository = detalleCompraRepository;
    }
}
