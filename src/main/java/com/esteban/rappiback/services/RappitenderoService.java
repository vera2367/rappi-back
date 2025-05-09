package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.Rappitendero;
import com.esteban.rappiback.repositorys.RappitenderoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RappitenderoService {

    private final RappitenderoRepository rappitenderoRepository;

    public RappitenderoService(RappitenderoRepository rappitenderoRepository) {
        this.rappitenderoRepository = rappitenderoRepository;
    }

    public List<Rappitendero> getAll() {
        return this.rappitenderoRepository.findAll();
    }

    public Rappitendero get(String id) {
        return this.rappitenderoRepository.findById(id).orElse(null);
    }

    public Rappitendero save(Rappitendero rappitendero) {
        return this.rappitenderoRepository.save(rappitendero);
    }

    public void delete(String id) {
        this.rappitenderoRepository.deleteById(id);
    }

    public Boolean exists(String id) {
        return this.rappitenderoRepository.existsById(id);
    }
}
