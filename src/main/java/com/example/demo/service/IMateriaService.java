package com.example.demo.service;

import com.example.demo.repository.model.Materia;

public interface IMateriaService {
    public void createMateria(Materia materia);
    public Materia readByNombreMateria(String nombre);
}
