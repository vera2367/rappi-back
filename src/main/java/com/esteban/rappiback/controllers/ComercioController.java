package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.Comercio;
import com.esteban.rappiback.services.ComercioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comercio")
public class ComercioController {
    private final ComercioService comercioService;

    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;
    }

    @GetMapping
    public ResponseEntity<List<Comercio>> getAll() {
        return ResponseEntity.ok(comercioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comercio> get(@PathVariable String id) {
        return ResponseEntity.ok(comercioService.get(id));
    }

    @PostMapping
    public ResponseEntity<Comercio> add(@RequestBody Comercio comercio) {
        if(comercio.getIdComercio() == null || !comercioService.exists(comercio.getIdComercio())) {
            return ResponseEntity.ok(this.comercioService.save(comercio));
        }
        return ResponseEntity.badRequest().body(comercio);
    }

    @PutMapping
    public ResponseEntity<Comercio> update(@RequestBody Comercio comercio) {
        if(!comercioService.exists(comercio.getIdComercio())) {
             return ResponseEntity.ok(this.comercioService.save(comercio));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idcomercio}")
    public ResponseEntity<Comercio> delete(@PathVariable String idcomercio) {
        if(!comercioService.exists(idcomercio)) {
            this.comercioService.delete(idcomercio);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
