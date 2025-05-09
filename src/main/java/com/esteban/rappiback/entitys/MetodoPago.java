package com.esteban.rappiback.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
    @Column(name = "id_metodo_pago", nullable = false)
    private Integer id;

    @Column(name = "nombre_metodo", nullable = false, length = 50)
    private String nombreMetodo;

}