package com.example.demo.service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl implements IMateriaService{
    @Autowired
    private IMateriaRepository materiaRepository;
    @Override
    public void createMateria(Materia materia) {
        this.materiaRepository.create(materia);
    }

    @Override
    public Materia readByNombreMateria(String nombre) {
        return this.materiaRepository.readByNombre(nombre);
    }
}
