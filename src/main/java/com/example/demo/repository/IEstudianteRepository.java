package com.example.demo.repository;
import com.example.demo.repository.model.Estudiante;

import java.util.List;

public interface IEstudianteRepository {
    public Estudiante getEstudianteCedula(String cedula);
    public List<Estudiante> getEstudiantes();
    public void eliminarEstudiate(String cedula);
    public void insertarEstudiante(Estudiante estudiante);
    public void actualizarEstudiante(Estudiante estudiante);


}
