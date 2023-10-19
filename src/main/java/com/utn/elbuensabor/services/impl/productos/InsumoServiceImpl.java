package com.utn.elbuensabor.services.impl.productos;

import com.utn.elbuensabor.entities.productos.Insumo;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.InsumoRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsumoServiceImpl extends BaseServiceImpl<Insumo, Long> implements InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;

    public InsumoServiceImpl(BaseRepository<Insumo, Long> baseRepository, InsumoRepository insumoRepository) {
        super(baseRepository);
        this.insumoRepository = insumoRepository;
    }
}
