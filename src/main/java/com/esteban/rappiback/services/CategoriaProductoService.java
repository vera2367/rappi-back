package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.CategoriaProducto;
import com.esteban.rappiback.repositorys.CategoriaProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoService {

    private final CategoriaProductoRepository categoriaProductoRepository;

    public CategoriaProductoService(CategoriaProductoRepository categoriaProductoRepository) {
        this.categoriaProductoRepository = categoriaProductoRepository;
    }

    public List<CategoriaProducto> getAll() {
            return this.categoriaProductoRepository.findAll();
    }

    public CategoriaProducto get(String id) {
        return this.categoriaProductoRepository.findById(id).orElse(null);
    }

    public CategoriaProducto save(CategoriaProducto categoriaProducto) {
        return this.categoriaProductoRepository.save(categoriaProducto);
    }

    public void delete(String id) {
            this.categoriaProductoRepository.deleteById(id);
    }

    public Boolean exists(String id) {
        return this.categoriaProductoRepository.existsById(id);
    }

}
