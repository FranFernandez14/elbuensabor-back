package com.utn.elbuensabor.services.usuarios;

import com.utn.elbuensabor.entities.usuarios.NotaCredito;
import com.utn.elbuensabor.services.BaseService;

import java.math.BigDecimal;
import java.util.Date;

public interface NotaCreditoService extends BaseService<NotaCredito, Long> {
    BigDecimal movimientos (Date fechaDesde, Date fechaHasta) throws Exception;
}
