package com.jorgeseoane.mercadona.mercadona.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Destino.class)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Destino {

    @Id
    private Long id;
    private String nombre;
    private String descripcion;

}
