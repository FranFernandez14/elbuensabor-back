package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.Rubro;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.RubroRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroServiceImpl extends BaseServiceImpl<Rubro, Long> implements RubroService {

    @Autowired
    private RubroRepository rubroRepository;

    public RubroServiceImpl(BaseRepository<Rubro, Long> baseRepository, RubroRepository rubroRepository) {
        super(baseRepository);
        this.rubroRepository = rubroRepository;
    }

    public List<Rubro> search(String filtro) throws Exception {
        try {
            List<Rubro> rubros = rubroRepository.search(filtro);
            return rubros;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public Page<Rubro> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Rubro> rubros = rubroRepository.search(filtro, pageable);
            return rubros;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Rubro> searchNative(String filtro) throws Exception {
        try{
            List<Rubro> rubros = rubroRepository.searchNative(filtro);
            return rubros;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
