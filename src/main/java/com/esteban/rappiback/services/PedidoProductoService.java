package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.PedidoProducto;
import com.esteban.rappiback.repositorys.PedidoProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProductoService {

    private final PedidoProductoRepository pedidoProductoRepository;

    public PedidoProductoService(PedidoProductoRepository pedidoProductoRepository) {
        this.pedidoProductoRepository = pedidoProductoRepository;
    }

    public List<PedidoProducto> getAll() {
        return pedidoProductoRepository.findAll();
    }

}
