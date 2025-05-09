package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.ComentarioProducto;
import com.esteban.rappiback.services.ComentarioProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarioproducto")
public class ComentarioProductoController {

    private final ComentarioProductoService comentarioProductoService;

    public ComentarioProductoController(ComentarioProductoService comentarioProductoService) {
        this.comentarioProductoService = comentarioProductoService;
    }

    @GetMapping
    public ResponseEntity<List<ComentarioProducto>> getAll() {
        return ResponseEntity.ok(this.comentarioProductoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioProducto> get(@PathVariable String id) {
        return ResponseEntity.ok(this.comentarioProductoService.get(id));
    }

    @PostMapping
    public ResponseEntity<ComentarioProducto> add(@RequestBody ComentarioProducto comentarioProducto) {
        if (comentarioProducto.getIdComentario() == null || !comentarioProductoService.exists(comentarioProducto.getIdComentario())) {
            return ResponseEntity.ok(this.comentarioProductoService.save(comentarioProducto));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ComentarioProducto> update(@RequestBody ComentarioProducto comentarioProducto) {
        if (comentarioProductoService.exists(comentarioProducto.getIdComentario())) {
            return ResponseEntity.ok(this.comentarioProductoService.save(comentarioProducto));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idcomentario}")
    public ResponseEntity<ComentarioProducto> delete(@PathVariable String idcomentario) {
        if (comentarioProductoService.exists(idcomentario)) {
            this.comentarioProductoService.delete(idcomentario);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}