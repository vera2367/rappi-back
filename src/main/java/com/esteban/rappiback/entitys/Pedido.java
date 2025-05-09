package com.esteban.rappiback.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @Column(name = "id_pedido", nullable = false, length = 100)
    private String idPedido;

   // @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private String idUsuario;

    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_comercio")
    private String idComercio;

    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rappitendero")
    private String idRappitendero;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_pedido", nullable = false)
    private Instant fechaPedido;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "costo_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal costoTotal;

    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pago")
    private String metodoPago;

}