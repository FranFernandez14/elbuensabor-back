package com.utn.elbuensabor.services.usuarios;

import com.utn.elbuensabor.dtos.CambiarContraseñaDTO;
import com.utn.elbuensabor.dtos.CambiarDatosDTO;
import com.utn.elbuensabor.dtos.RankingPersonasDTO;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.usuarios.PersonaRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository){
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public boolean cambiarContrasena(CambiarContraseñaDTO cambiarContraseñaDTO) throws Exception{
        try{
            Persona persona = personaRepository.getReferenceById(cambiarContraseñaDTO.getId());
            if (persona.getPassword().equals(cambiarContraseñaDTO.getContraseñaActual())) {
                personaRepository.cambiarContrasena(cambiarContraseñaDTO.getId(), cambiarContraseñaDTO.getContraseñaNueva());
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Persona cambiarDatos(CambiarDatosDTO cambiarDatosDTO) throws Exception{
        try{
            Persona persona = personaRepository.findById(cambiarDatosDTO.getId()).get();

            persona.setEmail(cambiarDatosDTO.getEmail());
            persona.setApellido(cambiarDatosDTO.getApellido());
            persona.setNombre(cambiarDatosDTO.getNombre());
            persona.setRol(cambiarDatosDTO.getRol());
            persona.setTelefono(cambiarDatosDTO.getTelefono());

            personaRepository.save(persona);

            return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<RankingPersonasDTO> ranking(Date fechaInicio, Date fechaFin, Pageable pageable) throws Exception{
        try{
            Page<RankingPersonasDTO> personas=personaRepository.ranking(fechaInicio,fechaFin,pageable);

            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
