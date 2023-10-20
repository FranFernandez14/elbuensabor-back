package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.CompraInsumo;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.CompraInsumoRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraInsumoServiceImpl extends BaseServiceImpl<CompraInsumo, Long> implements CompraInsumoService {

    @Autowired
    private CompraInsumoRepository compraInsumoRepository;

    public CompraInsumoServiceImpl(BaseRepository<CompraInsumo, Long> baseRepository, CompraInsumoRepository compraInsumoRepository) {
        super(baseRepository);
        this.compraInsumoRepository = compraInsumoRepository;
    }

}
