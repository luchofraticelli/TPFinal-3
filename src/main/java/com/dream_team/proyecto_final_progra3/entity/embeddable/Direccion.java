package com.dream_team.proyecto_final_progra3.entity.embeddable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable

public class Direccion {
    private String calle;
    private String numero;
    private String ciudad;
    private String provincia;
    private String codigoPostal;
    private String pais;
}