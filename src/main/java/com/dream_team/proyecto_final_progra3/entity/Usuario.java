package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.embeddable.Direccion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    private String telefono;
    private String email;

    @Embedded
    private Direccion direccion;

    @Column(nullable = false)
    private String permisos; // administrador, empleado, pasajero

    @Column(name = "cuenta_no_expirada")
    private boolean cuentaNoExpirada = true;

    @Column(name = "cuenta_no_bloqueada")
    private boolean cuentaNoBloqueada = true;

    @Column(name = "credenciales_no_expiradas")
    private boolean credencialesNoExpiradas = true;

    private boolean activo = true;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Credenciales credenciales;

    @OneToOne(mappedBy = "usuario")
    private Empleado empleado;

    @OneToOne(mappedBy = "usuario")
    private Pasajero pasajero;
}