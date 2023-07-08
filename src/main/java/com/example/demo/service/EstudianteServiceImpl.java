package com.example.demo.service;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    public Estudiante getEstudianteCedula(String cedula) {
        return this.estudianteRepository.getEstudianteCedula(cedula);
    }
}
