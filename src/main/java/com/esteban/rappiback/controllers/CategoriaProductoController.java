package com.esteban.rappiback.controllers;


import com.esteban.rappiback.entitys.CategoriaProducto;
import com.esteban.rappiback.services.CategoriaProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoriaproducto")
public class CategoriaProductoController {

    private final CategoriaProductoService categoriaProductoService;

    public CategoriaProductoController(CategoriaProductoService categoriaProductoService) {
        this.categoriaProductoService = categoriaProductoService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaProducto>> getAll() {
        return ResponseEntity.ok(this.categoriaProductoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProducto> get(@PathVariable String id) {
        return ResponseEntity.ok(this.categoriaProductoService.get(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaProducto> add(@RequestBody CategoriaProducto categoriaProducto) {
        if(categoriaProducto.getIdCategoria() == null || !categoriaProductoService.exists(categoriaProducto.getIdCategoria())) {
            return ResponseEntity.ok(this.categoriaProductoService.save(categoriaProducto));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<CategoriaProducto> update(@RequestBody CategoriaProducto categoriaProducto) {
        if(categoriaProductoService.exists(categoriaProducto.getIdCategoria())) {
            return ResponseEntity.ok(this.categoriaProductoService.save(categoriaProducto));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<CategoriaProducto> delete(@PathVariable String idCategoria) {
        if(categoriaProductoService.exists(idCategoria)) {
            this.categoriaProductoService.delete(idCategoria);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
