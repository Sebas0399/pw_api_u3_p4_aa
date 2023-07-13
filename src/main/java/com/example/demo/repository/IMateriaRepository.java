package com.example.demo.repository;

import com.example.demo.repository.model.Materia;

public interface IMateriaRepository {
    public void create(Materia materia);
    public Materia readByNombre(String nombre);
}
