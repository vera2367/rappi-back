package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.Comercio;
import com.esteban.rappiback.repositorys.ComercioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercioService {
    private final ComercioRepository comercioRepository;

    public ComercioService(ComercioRepository comercioRepository) {
        this.comercioRepository = comercioRepository;
    }

    public List<Comercio> getAll() {
        return this.comercioRepository.findAll();
    }

    public Comercio get(String id) {
        return this.comercioRepository.findById(id).orElse(null);
    }

    public Comercio save(Comercio comercio) {
        return this.comercioRepository.save(comercio);
    }

    public void delete(String id) {
        this.comercioRepository.deleteById(id);
    }

    public Boolean exists(String id) {
        return this.comercioRepository.existsById(id);
    }

}
