package com.example.demo.repository.model;

import jakarta.persistence.*;

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
    @Column(name = "est_provincia")

    private String provincia;

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
