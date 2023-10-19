package com.utn.elbuensabor.services.impl.productos;

import com.utn.elbuensabor.entities.productos.Receta;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.RecetaRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetaServiceImpl extends BaseServiceImpl<Receta, Long> implements RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;


    public RecetaServiceImpl(BaseRepository<Receta, Long> baseRepository, RecetaRepository recetaRepository) {
        super(baseRepository);
        this.recetaRepository = recetaRepository;
    }
}
