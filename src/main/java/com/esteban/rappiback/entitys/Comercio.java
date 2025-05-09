package com.esteban.rappiback.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "comercio")
public class Comercio {
    @Id
    @Column(name = "id_comercio", nullable = false, length = 100)
    private String idComercio;

    @Column(name = "nombre_comercio", nullable = false, length = 100)
    private String nombreComercio;

    @Column(name = "tipo_comercio", nullable = false, length = 50)
    private String tipoComercio;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "horario", nullable = false, length = 100)
    private String horario;

    @ColumnDefault("0.00")
    @Column(name = "ventas", precision = 10, scale = 2)
    private BigDecimal ventas;

    @ColumnDefault("0.00")
    @Column(name = "calificacion", precision = 3, scale = 2)
    private BigDecimal calificacion;

}