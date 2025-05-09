package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.ValoracionRappitendero;
import com.esteban.rappiback.services.ValoracionRappitenderoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valoracion")
public class ValoracionRappitenderoController {

    private final ValoracionRappitenderoService rappitenderoService;

    public ValoracionRappitenderoController(ValoracionRappitenderoService rappitenderoService) {
        this.rappitenderoService = rappitenderoService;
    }

    @GetMapping
    public ResponseEntity<List<ValoracionRappitendero>> getAll() {
        return ResponseEntity.ok(rappitenderoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValoracionRappitendero> get(@PathVariable String id) {
        return ResponseEntity.ok(this.rappitenderoService.get(id));
    }

    @PostMapping
    public ResponseEntity<ValoracionRappitendero> add(@RequestBody ValoracionRappitendero valoracionRappitendero) {
        if (valoracionRappitendero.getIdRappitendero() == null || !rappitenderoService.exists(valoracionRappitendero.getIdRappitendero())) {
            return ResponseEntity.ok(this.rappitenderoService.save(valoracionRappitendero));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ValoracionRappitendero> update(@RequestBody ValoracionRappitendero valoracionRappitendero) {
        if(rappitenderoService.exists(valoracionRappitendero.getIdRappitendero())) {
            return ResponseEntity.ok(this.rappitenderoService.save(valoracionRappitendero));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ValoracionRappitendero> delete(@PathVariable String id) {
        if (rappitenderoService.exists(id)) {
            rappitenderoService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
