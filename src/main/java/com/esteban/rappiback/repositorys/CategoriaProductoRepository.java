package com.esteban.rappiback.repositorys;

import com.esteban.rappiback.entitys.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, String> {



}