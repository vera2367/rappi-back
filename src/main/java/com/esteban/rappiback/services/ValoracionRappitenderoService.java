package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.ValoracionRappitendero;
import com.esteban.rappiback.repositorys.ValoracionRappitenderoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionRappitenderoService {

    private final ValoracionRappitenderoRepository valoracionRappitenderoRepository;

    public ValoracionRappitenderoService(ValoracionRappitenderoRepository valoracionRappitenderoRepository) {
        this.valoracionRappitenderoRepository = valoracionRappitenderoRepository;
    }

    public List<ValoracionRappitendero> getAll() {
        return this.valoracionRappitenderoRepository.findAll();
    }

    public ValoracionRappitendero get(String id) {
        return this.valoracionRappitenderoRepository.findById(id).orElse(null);
    }

    public ValoracionRappitendero save(ValoracionRappitendero valoracionRappitendero) {
       return this.valoracionRappitenderoRepository.save(valoracionRappitendero);
    }

    public void delete(String valoracionRappitendero) {
        valoracionRappitenderoRepository.deleteById(valoracionRappitendero);
    }

    public Boolean exists(String valoracionRappitendero) {
        return this.valoracionRappitenderoRepository.existsById(valoracionRappitendero);
    }
}
