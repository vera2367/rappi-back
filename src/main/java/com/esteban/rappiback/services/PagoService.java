package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.Pago;
import com.esteban.rappiback.repositorys.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> getAll() {
        return pagoRepository.findAll();
    }

    public Pago getById(String id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    public void delete(String id) {
        pagoRepository.deleteById(id);
    }

    public Boolean exists(String id) {
        return pagoRepository.existsById(id);
    }
}
