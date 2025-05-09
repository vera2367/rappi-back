package com.esteban.rappiback.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "valoracion_rappitendero")
public class ValoracionRappitendero {
    @Id
    @Column(name = "id_valoracion", nullable = false, length = 100)
    private String idValoracion;

   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rappitendero")
    private String idRappitendero;

   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private String idUsuario;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Lob
    @Column(name = "comentario")
    private String comentario;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_valoracion", nullable = false)
    private Instant fechaValoracion;

}