package com.utn.elbuensabor.repositories.usuarios;

import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.usuarios.Usuario;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    @Query(
            value = "UPDATE Usuario SET password = :contrasenaNueva WHERE id = :id"
    )
    public Usuario cambiarContrasena(@Param("id") Long id,
                                     @Param("contrasenaNueva") String contrasenaNueva);


    @Query(
            value = "UPDATE Usuario " +
                    "SET nombre = :nombre, " +
                    "apellido = :apellido, " +
                    "telefono = :telefono, " +
                    "rol = :rol, " +
                    "email = :email " +
                    "WHERE id = :id"
    )
    public Usuario cambiarDatos(@Param("id") Long id,
                                @Param("nombre") String nombre,
                                @Param("apellido") String apellido,
                                @Param("telefono") String telefono,
                                @Param("rol") Rol rol,
                                @Param("email") String email);


    @Query(
            value = "SELECT u, COUNT(p) AS CantidadPedidos, SUM(f.totalVenta) AS Total FROM Usuario AS u LEFT JOIN u.pedidos p, Factura AS f " +
                    "WHERE f.pedido = p " +
                    "AND fechaFacturacion BETWEEN :inicio AND :fin " +
                    "ORDER BY :ordenar"
    )
    public Page<Usuario> ranking(@Param("inicio") Date fechaInicio,
                                 @Param("fin") Date fechaFin,
                                 @Param("ordenar") String ordenar,
                                 Pageable pageable);
}
