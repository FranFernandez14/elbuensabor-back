package com.utn.elbuensabor.services.impl.productos;

import com.utn.elbuensabor.entities.productos.DetalleReceta;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.DetalleRecetaRepository;
import com.utn.elbuensabor.services.productos.DetalleRecetaService;
import org.springframework.beans.factory.annotation.Autowired;

import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DetalleRecetaServiceImpl extends BaseServiceImpl<DetalleReceta, Long> implements DetalleRecetaService {

    @Autowired
    private DetalleRecetaRepository detalleRecetaRepository;

    public DetalleRecetaServiceImpl(BaseRepository<DetalleReceta, Long> baseRepository, DetalleRecetaRepository detalleRecetaRepository) {
        super(baseRepository);
        this.detalleRecetaRepository = detalleRecetaRepository;
    }
}
