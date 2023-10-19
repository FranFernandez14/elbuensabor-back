package com.utn.elbuensabor.services.impl.productos;

import com.utn.elbuensabor.entities.productos.Rubro;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.RubroRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroServiceImpl extends BaseServiceImpl<Rubro, Long> implements RubroService {

    @Autowired
    private RubroRepository rubroRepository;

    public RubroServiceImpl(BaseRepository<Rubro, Long> baseRepository, RubroRepository rubroRepository) {
        super(baseRepository);
        this.rubroRepository = rubroRepository;
    }
}
