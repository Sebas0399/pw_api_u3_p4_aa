package com.example.demo.repository;
import com.example.demo.repository.model.Estudiante;

import java.util.List;

public interface IEstudianteRepository {
    public Estudiante getEstudianteCedula(String cedula);
    public Estudiante getEstudianteId(Integer id);

    public List<Estudiante> getEstudiantes();
    public List<Estudiante> getEstudiantes(String provincia);

    public void eliminarEstudiate(String cedula);
    public void eliminarEstudiate(Integer id);

    public void insertarEstudiante(Estudiante estudiante);
    public void actualizarEstudiante(Estudiante estudiante);
    public void actualizarParcial(String cedulaActual,String cedulaNueva);


}
