package com.example.demo.service;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    public Estudiante getEstudianteCedula(String cedula) {
        return this.estudianteRepository.getEstudianteCedula(cedula);
    }

    @Override
    public List<Estudiante> getEstudiantes() {
        return this.estudianteRepository.getEstudiantes();
    }

    @Override
    public void eliminarEstudiate(String cedula) {
        this.estudianteRepository.eliminarEstudiate(cedula);
    }

    @Override
    public void insertarEstudiante(Estudiante estudiante) {
        this.estudianteRepository.insertarEstudiante(estudiante);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        this.estudianteRepository.actualizarEstudiante(estudiante);
    }

    @Override
    public void actualizarParcial(String cedulaActual, String cedulaNueva) {
        this.estudianteRepository.actualizarParcial(cedulaActual,cedulaNueva);
    }

    @Override
    public void eliminarEstudiate(Integer id) {
        this.estudianteRepository.eliminarEstudiate(id);
    }

    @Override
    public List<Estudiante> getEstudiantes(String provincia) {
        return this.estudianteRepository.getEstudiantes(provincia);
    }
}
