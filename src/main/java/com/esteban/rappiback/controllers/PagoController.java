package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.Pago;
import com.esteban.rappiback.services.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public ResponseEntity<List<Pago>> getAll() {
        return ResponseEntity.ok(pagoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> get(@PathVariable String id) {
        return ResponseEntity.ok(this.pagoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Pago> add(@RequestBody Pago pago) {
        if(pago.getIdPago() == null || !pagoService.exists(pago.getIdPago())) {
            return ResponseEntity.ok(pagoService.save(pago));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Pago> update(@RequestBody Pago pago) {
        if(pagoService.exists(pago.getIdPago())) {
            return ResponseEntity.ok(pagoService.save(pago));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Pago> delete(@PathVariable String id) {
        if(pagoService.exists(id)) {
            this.pagoService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
