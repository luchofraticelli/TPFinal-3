package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.enums.ServAdicionalEnum;
import com.dream_team.proyecto_final_progra3.entity.ServAdicional;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Servicios_Adicionales")
    public class ServAdicional {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated (EnumType.STRING)
        @Column (name = "nombre", nullable = false, unique = true)
        private ServAdicionalEnum nombre;

        private String descripcion;

    public ServAdicionalEnum getNombre() {
        return nombre;
    }
    public void setNombre(ServAdicionalEnum nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
