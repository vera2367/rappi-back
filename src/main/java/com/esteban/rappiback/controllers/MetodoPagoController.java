package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.MetodoPago;
import com.esteban.rappiback.services.MetodoPagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodopago")
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping
    public ResponseEntity<List<MetodoPago>> getAll() {
        return ResponseEntity.ok(this.metodoPagoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> get(@PathVariable Integer id) {
        return ResponseEntity.ok(this.metodoPagoService.get(id));
    }

    @PostMapping
    public ResponseEntity<MetodoPago> add(@RequestBody MetodoPago metodoPago) {
        if(metodoPago.getId() == null || !metodoPagoService.exists(metodoPago.getId())) {
            return ResponseEntity.ok(this.metodoPagoService.save(metodoPago));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{idMetodo}")
    public ResponseEntity<MetodoPago> update(@RequestBody Integer idMetodoPago) {
        if (metodoPagoService.exists(idMetodoPago)) {
            this.metodoPagoService.delete((idMetodoPago));
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
