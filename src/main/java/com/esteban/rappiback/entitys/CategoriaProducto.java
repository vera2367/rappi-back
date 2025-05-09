package com.esteban.rappiback.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoria_producto")
public class CategoriaProducto {
    @Id
    @Column(name = "id_categoria", nullable = false, length = 100)
    private String idCategoria;

    @Column(name = "nombre_categoria", nullable = false, length = 50)
    private String nombreCategoria;

}