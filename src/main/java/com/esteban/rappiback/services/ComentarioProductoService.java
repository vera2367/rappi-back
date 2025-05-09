package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.ComentarioProducto;
import com.esteban.rappiback.repositorys.ComentarioProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioProductoService {

    private final ComentarioProductoRepository comentarioProductoRepository;

    public ComentarioProductoService(ComentarioProductoRepository comentarioProductoRepository) {
        this.comentarioProductoRepository = comentarioProductoRepository;
    }

    public List<ComentarioProducto> getAll() {
        return this.comentarioProductoRepository.findAll();
    }

    public ComentarioProducto get(String id) {
        return this.comentarioProductoRepository.findById(id).orElse(null);
    }

    public ComentarioProducto save(ComentarioProducto comentarioProducto) {
        return this.comentarioProductoRepository.save(comentarioProducto);
    }

    public void delete(String comentarioProducto) {
        this.comentarioProductoRepository.deleteById(comentarioProducto);
    }
    public Boolean exists(String id) {
        return this.comentarioProductoRepository.existsById(id);
    }

}
