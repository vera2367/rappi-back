package com.esteban.rappiback.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @Column(name = "id_pago", nullable = false, length = 100)
    private String idPago;

   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private String idPedido;

   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_pago", nullable = false)
    private Instant fechaPago;

}