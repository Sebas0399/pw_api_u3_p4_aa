package com.example.demo.service;

import com.example.demo.repository.model.Materia;
import org.springframework.stereotype.Service;


public interface IMateriaService {
    public void createMateria(Materia materia);
    public Materia readByNombreMateria(String nombre);
}
