package com.example.demo.service.to;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class MateriaTO extends RepresentationModel<MateriaTO> implements Serializable {
    public static final long serialVersionUID=1L;
    private Integer id;
    private String nombre;
    private Integer numeroCreditos;

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

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }
}