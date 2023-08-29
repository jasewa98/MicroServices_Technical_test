package com.jorgeseoane.mercadona.mercadona.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_producto",
        scope = Producto.class)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    private Long id_producto;
    private String ean;
    private String nombre;
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_proveedor", nullable=false)
    private Proveedor id_proveedor;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_destino", nullable=false)
    private Destino id_destino;


}
