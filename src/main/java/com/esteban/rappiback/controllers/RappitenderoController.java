package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.Rappitendero;
import com.esteban.rappiback.services.RappitenderoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rappitendero")
public class RappitenderoController {

    private final RappitenderoService rappitenderoService;

    public RappitenderoController(RappitenderoService rappitenderoService) {
        this.rappitenderoService = rappitenderoService;
    }

    @GetMapping
    public ResponseEntity<List<Rappitendero>> getAll() {
        return ResponseEntity.ok(this.rappitenderoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rappitendero> get(@PathVariable String id) {
        return ResponseEntity.ok(this.rappitenderoService.get(id));
    }


    @PostMapping
    public ResponseEntity<Rappitendero> create(@RequestBody Rappitendero rappitendero) {
        if(rappitendero.getIdRappitendero() == null || !rappitenderoService.exists(rappitendero.getIdRappitendero())) {
            return ResponseEntity.ok(this.rappitenderoService.save(rappitendero));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Rappitendero> update(@RequestBody Rappitendero rappitendero) {
        if(rappitenderoService.exists(rappitendero.getIdRappitendero())) {
            return ResponseEntity.ok(this.rappitenderoService.save(rappitendero));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if(rappitenderoService.exists(id)) {
            this.rappitenderoService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
