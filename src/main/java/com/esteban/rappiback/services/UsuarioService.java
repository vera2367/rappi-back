package com.esteban.rappiback.services;

import com.esteban.rappiback.entitys.Usuario;
import com.esteban.rappiback.repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario get(String id) {
        return this.usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public void delete(String id) {
        this.usuarioRepository.deleteById(id);
    }

    public Boolean exists(String id) {
        return this.usuarioRepository.existsById(id);
    }
}
