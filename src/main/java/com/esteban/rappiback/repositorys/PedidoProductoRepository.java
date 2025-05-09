package com.esteban.rappiback.repositorys;

import com.esteban.rappiback.entitys.PedidoProducto;
import com.esteban.rappiback.entitys.PedidoProductoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, PedidoProductoId> {
}