package com.utn.elbuensabor.services.impl.productos;

import com.utn.elbuensabor.entities.productos.CompraInsumo;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.CompraInsumoRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.CompraInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraInsumoServiceImpl extends BaseServiceImpl<CompraInsumo, Long> implements CompraInsumoService {

    @Autowired
    private CompraInsumoRepository compraInsumoRepository;

    public CompraInsumoServiceImpl(BaseRepository<CompraInsumo, Long> baseRepository, CompraInsumoRepository compraInsumoRepository) {
        super(baseRepository);
        this.compraInsumoRepository = compraInsumoRepository;
    }
}
