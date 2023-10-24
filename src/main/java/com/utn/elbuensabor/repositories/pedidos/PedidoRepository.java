package com.utn.elbuensabor.repositories.pedidos;

import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    //  Este método solo coloca el estado actual.
    //  Para agregar un PedidoEstado al historial, se debe llamar dentro del mismo servicio
    //  a este mismo método y a save para el PedidoEstado correspondiente.
    @Query(
            value = "UPDATE Pedido " +
                    "SET estadoActual = :estado " +
                    "WHERE id = :id"
    )
    public List<Pedido> cambiarEstado(@Param("id") Long id,
                                @Param("estado") EstadoPedido estadoPedido);

    @Query(
            value = "SElECT p FROM Pedido p " +
                    "WHERE id LIKE %:id% " +
                    "AND estadoActual IN :estados"
    )
    public Page<Pedido> buscar(@Param("id") Long id,
                               @Param("estados")List<EstadoPedido> estados,
                               Pageable pageable);
}
