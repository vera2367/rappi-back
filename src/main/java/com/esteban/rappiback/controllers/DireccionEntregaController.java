package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.DireccionEntrega;
import com.esteban.rappiback.services.DireccionEntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direccionentrega")
public class DireccionEntregaController {

    private final DireccionEntregaService direccionEntregaService;

    public DireccionEntregaController(DireccionEntregaService direccionEntregaService) {
        this.direccionEntregaService = direccionEntregaService;
    }

    @GetMapping
    public ResponseEntity<List<DireccionEntrega>> getAll() {
        return ResponseEntity.ok(direccionEntregaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionEntrega> get(@PathVariable String id) {
        return ResponseEntity.ok(direccionEntregaService.get(id));
    }

    @PostMapping
    public ResponseEntity<DireccionEntrega> add(@RequestBody DireccionEntrega direccionEntrega) {
        if(direccionEntrega.getIdDireccion() == null || !direccionEntregaService.exists(direccionEntrega.getIdDireccion())) {
            return ResponseEntity.ok(this.direccionEntregaService.save(direccionEntrega));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<DireccionEntrega> update(@RequestBody DireccionEntrega direccionEntrega) {
        if(!direccionEntregaService.exists(direccionEntrega.getIdDireccion())) {
            return ResponseEntity.ok(this.direccionEntregaService.save(direccionEntrega));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DireccionEntrega> delete(@PathVariable String id) {
        if(!direccionEntregaService.exists(id)) {
            this.direccionEntregaService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
