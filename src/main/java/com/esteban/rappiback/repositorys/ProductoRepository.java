package com.esteban.rappiback.repositorys;

import com.esteban.rappiback.entitys.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {
}