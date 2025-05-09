package com.esteban.rappiback.dtos;

import java.math.BigDecimal;

public record IngresoComercioDTO(
        String idComercio,
        String nombreComercio,
        BigDecimal totalIngresos
) {
}
