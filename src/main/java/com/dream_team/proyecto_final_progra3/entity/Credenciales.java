package com.dream_team.proyecto_final_progra3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "credenciales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credenciales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "contrasena_hash", nullable = false)
    private String contrasenaHash;

    @Column(name = "fecha_ultimo_cambio")
    private LocalDateTime fechaUltimoCambio;

    @Column(name = "intentos_fallidos", columnDefinition = "INT DEFAULT 0")
    private int intentosFallidos = 0;
}