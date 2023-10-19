package com.utn.elbuensabor.services.impl.productos;

import com.utn.elbuensabor.entities.productos.RubroProducto;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.RubroProductoRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.RubroProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroProductoServiceImpl extends BaseServiceImpl<RubroProducto, Long> implements RubroProductoService {

    @Autowired
    private RubroProductoRepository rubroProductoRepository;

    public RubroProductoServiceImpl(BaseRepository<RubroProducto, Long> baseRepository, RubroProductoRepository rubroProductoRepository) {
        super(baseRepository);
        this.rubroProductoRepository = rubroProductoRepository;
    }
}
