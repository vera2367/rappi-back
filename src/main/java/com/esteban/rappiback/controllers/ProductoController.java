package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.Producto;
import com.esteban.rappiback.services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getALL() {
        return ResponseEntity.ok(productoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable String id) {
        return ResponseEntity.ok(this.productoService.get(id));
    }

    @PostMapping
    public ResponseEntity<Producto> add(@RequestBody Producto producto) {
        if(producto.getIdProducto() == null || !productoService.exists(producto.getIdProducto())) {
            return ResponseEntity.ok(this.productoService.save(producto));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Producto> update(@RequestBody Producto producto) {
        if(productoService.exists(producto.getIdProducto())) {
            return ResponseEntity.ok(this.productoService.save(producto));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> delete(@PathVariable String id) {
        if(productoService.exists(id)) {
            this.productoService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
