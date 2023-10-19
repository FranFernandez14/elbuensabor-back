package com.utn.elbuensabor.services.impl.productos;

import com.utn.elbuensabor.entities.productos.UnidadMedida;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.UnidadMedidaRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;


    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository, UnidadMedidaRepository unidadMedidaRepository) {
        super(baseRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }
}
