package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.MetodoPago;
import com.esteban.rappiback.repositorys.MetodoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoService {
    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    public List<MetodoPago> getAll() {
        return metodoPagoRepository.findAll();
    }

    public MetodoPago get(int id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public void delete(int id) {
        metodoPagoRepository.deleteById(id);
    }

    public Boolean exists(int id) {
        return metodoPagoRepository.existsById(id);
    }
}
