package com.esteban.rappiback.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "direccion_entrega")
public class DireccionEntrega {
    @Id
    @Column(name = "id_direccion", nullable = false, length = 100)
    private String idDireccion;

//@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private String idUsuario;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false, length = 100)
    private String ciudad;

    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;

}