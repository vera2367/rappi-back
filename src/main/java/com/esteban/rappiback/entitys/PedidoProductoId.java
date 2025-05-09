package com.esteban.rappiback.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PedidoProductoId implements Serializable {
    private static final long serialVersionUID = -7201741443160291484L;
    @Column(name = "id_pedido", nullable = false, length = 100)
    private String idPedido;

    @Column(name = "id_producto", nullable = false, length = 100)
    private String idProducto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PedidoProductoId entity = (PedidoProductoId) o;
        return Objects.equals(this.idProducto, entity.idProducto) &&
                Objects.equals(this.idPedido, entity.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idPedido);
    }

}