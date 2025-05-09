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
@Table(name = "rappitendero")
public class Rappitendero {
    @Id
    @Column(name = "id_rappitendero", nullable = false, length = 100)
    private String idRappitendero;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "placa_vehiculo", length = 50)
    private String placaVehiculo;

    @Column(name = "tipo_vehiculo", length = 50)
    private String tipoVehiculo;

    @ColumnDefault("1")
    @Column(name = "disponibilidad")
    private Boolean disponibilidad;

    @ColumnDefault("0.00")
    @Column(name = "calificacion", precision = 3, scale = 2)
    private BigDecimal calificacion;

}