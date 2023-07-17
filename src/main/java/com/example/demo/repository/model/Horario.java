package com.example.demo.repository.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hor_id", nullable = false)
    private Integer id;

    @Column(name = "hor_hora")
    private String hora;
    @Column(name = "hor_dia")

    private String dia;

    @OneToMany(mappedBy = "horario")
    private List<Materia>materias;

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}