package com.utn.elbuensabor.services.impl.usuarios;

import com.utn.elbuensabor.entities.usuarios.Domicilio;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.usuarios.DomicilioRepository;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import com.utn.elbuensabor.services.usuarios.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }
}
