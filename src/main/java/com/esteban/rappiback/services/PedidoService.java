package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.Pedido;
import com.esteban.rappiback.repositorys.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getAll() {
        return this.pedidoRepository.findAll();
    }

    public Pedido get(String id) {
        return this.pedidoRepository.findById(id).orElse(null);
    }

    public Pedido save(Pedido pedido) {
        return this.pedidoRepository.save(pedido);
    }

    public void delete(String id) {
        this.pedidoRepository.deleteById(id);
    }

    public Boolean exists(String id) {
        return this.pedidoRepository.existsById(id);
    }
}
