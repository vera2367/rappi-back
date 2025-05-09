package com.esteban.rappiback.controllers;

import com.esteban.rappiback.entitys.Usuario;
import com.esteban.rappiback.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(this.usuarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get( @PathVariable String id) {
        return ResponseEntity.ok(this.usuarioService.get(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> add(@RequestBody Usuario usuario) {
        if(usuario.getIdUsuario() == null || !usuarioService.exists(usuario.getIdUsuario())) {
            return ResponseEntity.ok(this.usuarioService.save(usuario));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        if(usuarioService.exists(usuario.getIdUsuario())) {
            return ResponseEntity.ok(this.usuarioService.save(usuario));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable String id) {
        if(usuarioService.exists(id)) {
            this.usuarioService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
