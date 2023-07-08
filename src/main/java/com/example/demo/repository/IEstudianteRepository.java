package com.example.demo.repository;
import com.example.demo.repository.model.Estudiante;

public interface IEstudianteRepository {
    public Estudiante getEstudianteCedula(String cedula);
}
