package com.example.demo.service;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.service.to.EstudianteTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
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
        this.estudianteRepository.actualizarParcial(cedulaActual, cedulaNueva);
    }

    @Override
    public void eliminarEstudiate(Integer id) {
        this.estudianteRepository.eliminarEstudiate(id);
    }

    @Override
    public List<Estudiante> getEstudiantes(String provincia) {
        return this.estudianteRepository.getEstudiantes(provincia);
    }

    @Override
    public List<EstudianteTO> getEstudiantesTO() {
        List<Estudiante> estudiantes = this.estudianteRepository.getEstudiantes();


        return estudiantes.stream().map(estu -> convertir(estu)).collect(Collectors.toList());
    }

    public EstudianteTO convertir(Estudiante estudiante) {
        EstudianteTO estudianteTO = new EstudianteTO();
        estudianteTO.setApellido(estudiante.getApellido());
        estudianteTO.setCedula(estudiante.getCedula());
        estudianteTO.setId(estudiante.getId());
        estudianteTO.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteTO.setProvincia(estudiante.getProvincia());
        estudianteTO.setNombre(estudiante.getNombre());
        return estudianteTO;
    }
}
