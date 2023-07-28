package com.example.demo.repository;

import com.example.demo.repository.model.Materia;

import java.util.List;

public interface IMateriaRepository {
    public void create(Materia materia);
    public Materia readByNombre(String nombre);
    public List<Materia> readByCedulaEstudiante(String cedula);
    public Materia readById(Integer id);


}
