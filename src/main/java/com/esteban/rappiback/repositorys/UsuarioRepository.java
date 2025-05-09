package com.esteban.rappiback.repositorys;

import com.esteban.rappiback.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}