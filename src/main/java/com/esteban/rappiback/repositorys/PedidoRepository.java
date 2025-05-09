package com.esteban.rappiback.repositorys;

import com.esteban.rappiback.entitys.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}