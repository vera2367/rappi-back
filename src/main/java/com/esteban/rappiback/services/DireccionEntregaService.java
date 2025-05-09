package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.DireccionEntrega;
import com.esteban.rappiback.repositorys.DireccionEntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionEntregaService {

    private final DireccionEntregaRepository direccionEntregaRepository;

    public DireccionEntregaService(DireccionEntregaRepository direccionEntregaRepository) {
        this.direccionEntregaRepository = direccionEntregaRepository;
    }

    public List<DireccionEntrega> getAll() {
        return direccionEntregaRepository.findAll();
    }

    public DireccionEntrega get(String id) {
        return this.direccionEntregaRepository.findById(id).orElse(null);
    }

    public DireccionEntrega save(DireccionEntrega direccionEntrega) {
        return this.direccionEntregaRepository.save(direccionEntrega);
    }

    public void delete(String id) {
        this.direccionEntregaRepository.deleteById(id);
    }

    public Boolean exists(String id) {
        return this.direccionEntregaRepository.existsById(id);
    }
}
