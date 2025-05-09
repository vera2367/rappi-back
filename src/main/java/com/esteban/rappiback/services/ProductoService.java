package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.Producto;
import com.esteban.rappiback.repositorys.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getAll() {
        return this.productoRepository.findAll();
    }

    public Producto get(String id) {
        return this.productoRepository.findById(id).orElse(null);
    }

    public Producto save(Producto producto) {
        return this.productoRepository.save(producto);
    }

    public void delete(String id) {
        this.productoRepository.deleteById(id);
    }

    public Boolean exists(String id) {
        return this.productoRepository.existsById(id);
    }
}
