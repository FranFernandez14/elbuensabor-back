package com.utn.elbuensabor.services.impl.facturacion;

import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.facturacion.FacturaRepository;
import com.utn.elbuensabor.services.facturacion.FacturaService;
import com.utn.elbuensabor.services.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService{

    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository= facturaRepository;
    }
}
