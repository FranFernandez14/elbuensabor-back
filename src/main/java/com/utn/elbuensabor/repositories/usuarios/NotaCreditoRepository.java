package com.utn.elbuensabor.repositories.usuarios;

import com.utn.elbuensabor.entities.usuarios.NotaCredito;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface NotaCreditoRepository extends BaseRepository<NotaCredito, Long> {
    @Query(
            value = "SELECT SUM(monto) " +
                    "FROM NotaCredito nc " +
                    "WHERE fechaAlta BETWEEN :inicio AND :fin"
    )
    public BigDecimal movimientos(@Param("inicio") Date fechaDesde, @Param("fin") Date fechaHasta);
}
