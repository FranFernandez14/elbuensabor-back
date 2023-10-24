package com.utn.elbuensabor.services.usuarios;

import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.usuarios.PersonaRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository){
        super(baseRepository);
        this.personaRepository = personaRepository;
    }
    @Override
    public List<Persona> cambiarContrasena(Long id,String contrasenaNueva) throws Exception{
        try{
            List<Persona> personas=personaRepository.cambiarContrasena(id,contrasenaNueva);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public List<Persona> cambiarDatos(Long id, String nombre, String apellido, String telefono, Rol rol, String email) throws Exception{
        try{
            List<Persona> personas=personaRepository.cambiarDatos(id,nombre,apellido,telefono,rol,email);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Persona> ranking(Date fechaInicio, Date fechaFin, String ordenar, Pageable pageable) throws Exception{
        try{
            Page<Persona> personas=personaRepository.ranking(fechaInicio,fechaFin,ordenar, pageable);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
