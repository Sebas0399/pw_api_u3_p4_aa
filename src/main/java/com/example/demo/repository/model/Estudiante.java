package com.example.demo.repository.model;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.Name;

@Table(name = "estudiante")
@Entity
public class Estudiante {
    @Id
    @Column(name = "est_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "est_nombre")
    private String nombre;
    @Column(name = "est_apellido")

    private String apellido;
    @Column(name = "est_cedula")

    private String cedula;
    @Column(name = "est_fecha_nacimiento")

    private String fechaNacimiento;
}
