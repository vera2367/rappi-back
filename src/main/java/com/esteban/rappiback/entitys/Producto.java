package com.esteban.rappiback.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "id_producto", nullable = false, length = 100)
    private String idProducto;

  //  @ManyToOne(fetch = FetchType.LAZY)
  //  @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_comercio")
    private String idComercio;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @ColumnDefault("1")
    @Column(name = "disponibilidad", nullable = false)
    private Boolean disponibilidad = false;

}