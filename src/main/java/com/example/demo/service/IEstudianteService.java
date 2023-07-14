package com.example.demo.service;

import com.example.demo.repository.model.Estudiante;

import java.util.List;

public interface IEstudianteService {
    public Estudiante getEstudianteCedula(String cedula);
    public List<Estudiante> getEstudiantes();
    public void eliminarEstudiate(String cedula);
    public void insertarEstudiante(Estudiante estudiante);
    public void actualizarEstudiante(Estudiante estudiante);
    public void actualizarParcial(String cedulaActual,String cedulaNueva);
    public void eliminarEstudiate(Integer id);
    public List<Estudiante> getEstudiantes(String provincia);


}
