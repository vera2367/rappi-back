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
public class ProductoCategoriaId implements Serializable {
    private static final long serialVersionUID = -6590666826369652772L;
    @Column(name = "id_producto", nullable = false, length = 100)
    private String idProducto;

    @Column(name = "id_categoria", nullable = false, length = 100)
    private String idCategoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductoCategoriaId entity = (ProductoCategoriaId) o;
        return Objects.equals(this.idProducto, entity.idProducto) &&
                Objects.equals(this.idCategoria, entity.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idCategoria);
    }

}