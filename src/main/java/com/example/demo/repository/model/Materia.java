package com.example.demo.repository.model;

import jakarta.persistence.*;

@Table(name = "materia")
@Entity
public class Materia {
    @Id
    @Column(name = "mat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "mat_nombre")
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
