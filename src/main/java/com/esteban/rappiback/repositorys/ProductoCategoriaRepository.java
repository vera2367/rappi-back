package com.esteban.rappiback.repositorys;

import com.esteban.rappiback.entitys.ProductoCategoria;
import com.esteban.rappiback.entitys.ProductoCategoriaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoCategoriaRepository extends JpaRepository<ProductoCategoria, ProductoCategoriaId> {
}