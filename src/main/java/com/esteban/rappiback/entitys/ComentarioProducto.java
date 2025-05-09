package com.esteban.rappiback.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "comentario_producto")
public class ComentarioProducto {
    @Id
    @Column(name = "id_comentario", nullable = false, length = 100)
    private String idComentario;

   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private String idProducto;

    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private String idUsuario;

    @Lob
    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "calificacion")
    private Integer calificacion;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_comentario", nullable = false)
    private Instant fechaComentario;

}