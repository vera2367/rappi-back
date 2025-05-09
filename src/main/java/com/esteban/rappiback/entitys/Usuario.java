package com.esteban.rappiback.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false, length = 100)
    private String idUsuario;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "correo_electronico", nullable = false, length = 100)
    private String correoElectronico;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

   // @ManyToOne(fetch = FetchType.LAZY)
   // @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "metodo_pago")
    private String metodoPago;

}