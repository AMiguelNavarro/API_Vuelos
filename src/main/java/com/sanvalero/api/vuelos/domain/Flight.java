package com.sanvalero.api.vuelos.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "flights")
public class Flight {

    @Schema(description = "Identificador del vuelo", example = "1", required = true)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;

    @Schema(description = "Origen/Salida del vuelo", example = "Zaragoza", required = true)
    @Column @NotBlank private String departure;

    @Schema(description = "Llegada del vuelo", example = "Zaragoza", required = true)
    @Column @NotBlank private String destination;

    @Schema(description = "Compañía con la que se vuela", example = "Ryanair", required = true)
    @Column @NotBlank private String company;

    @Schema(description = "Precio del vuelo", example = "55.0", required = true)
    @Column @NotBlank @Min(value = 0) private float price;

    @Schema(description = "Número de escalas del vuelo", example = "1")
    @Column @Min(value = 0) private int stopover;

}
