package com.utn.elbuensabor.services.impl.productos;

import com.utn.elbuensabor.entities.productos.RubroInsumo;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.RubroInsumoRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.RubroInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroInsumoServiceImpl extends BaseServiceImpl<RubroInsumo, Long> implements RubroInsumoService {

    @Autowired
    private RubroInsumoRepository rubroInsumoRepository;

    public RubroInsumoServiceImpl(BaseRepository<RubroInsumo, Long> baseRepository, RubroInsumoRepository rubroInsumoRepository) {
        super(baseRepository);
        this.rubroInsumoRepository = rubroInsumoRepository;
    }
}
