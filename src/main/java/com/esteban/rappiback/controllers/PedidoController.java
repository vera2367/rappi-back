package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.Pedido;
import com.esteban.rappiback.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll(){
        return ResponseEntity.ok(this.pedidoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> get(@PathVariable String id){
        return ResponseEntity.ok(this.pedidoService.get(id));
    }

    @PostMapping
    public ResponseEntity<Pedido> post(@RequestBody Pedido pedido){
        if(pedido.getIdPedido() == null || !pedidoService.exists(pedido.getIdPedido())){
            return ResponseEntity.ok(this.pedidoService.save(pedido));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido){
        if(pedidoService.exists(pedido.getIdPedido())){
            return ResponseEntity.ok(this.pedidoService.save(pedido));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> delete(@PathVariable String id){
        if(pedidoService.exists(id)){
            this.pedidoService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
