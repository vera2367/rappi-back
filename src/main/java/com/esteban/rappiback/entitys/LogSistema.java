package com.esteban.rappiback.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "log_sistema")
public class LogSistema {
    @Id
    @Column(name = "id_log", nullable = false)
    private Integer id;

    @Column(name = "tipo_evento", nullable = false, length = 50)
    private String tipoEvento;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_evento", nullable = false)
    private Instant fechaEvento;

    @Column(name = "ip_origen", length = 45)
    private String ipOrigen;

}