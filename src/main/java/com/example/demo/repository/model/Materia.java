package com.example.demo.repository.model;
import javax.persistence.*;


@Table(name = "materia")
@Entity
public class Materia {
    @Id
    @Column(name = "mat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "mat_nombre")
    private String nombre;
    @Column(name = "mat_numero_creditos")
    private Integer numeroCreditos;


    @ManyToOne
    @JoinColumn(name = "mat_est_id" )
    private Estudiante estudiante;


    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

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