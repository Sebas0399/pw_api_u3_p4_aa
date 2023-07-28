package com.example.demo.service;

import com.example.demo.repository.model.Materia;
import com.example.demo.service.to.MateriaTO;

import java.util.List;

public interface IMateriaService {
    public void createMateria(Materia materia);
    public Materia readByNombreMateria(String nombre);
    public List<MateriaTO> readByCedulaEstudiante(String cedula);
    public MateriaTO readById(Integer id);

}
