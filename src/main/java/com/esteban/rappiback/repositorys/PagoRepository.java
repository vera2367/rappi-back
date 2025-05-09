package com.esteban.rappiback.repositorys;

import com.esteban.rappiback.entitys.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, String> {
}