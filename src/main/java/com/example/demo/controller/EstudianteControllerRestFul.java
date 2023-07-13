package com.example.demo.controller;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {
    @Autowired
    private IEstudianteService estudianteService;
    @GetMapping(path = "/buscar")
    public Estudiante getEstudianteCedula(){
        String cedula="1725776650";
        return this.estudianteService.getEstudianteCedula(cedula);
    }
    @GetMapping(path = "/buscarTodo")
    public List<Estudiante> getEstudiantes(){

        return this.estudianteService.getEstudiantes();
    }
    @PostMapping(path = "/insertar")
    public void insertarEstudiante(@RequestBody Estudiante estudiante){
        this.estudianteService.insertarEstudiante(estudiante);
    }
    @PutMapping(path = "/actualizar")
    public void actualizarEstudiante(Estudiante estudiante){
        this.estudianteService.actualizarEstudiante(estudiante);
    }
    @PatchMapping(path = "/actualizarParcial")
    public void actualizarEstudianteParcial(Estudiante estudiante){
        this.estudianteService.actualizarEstudiante(estudiante);
    }
    @DeleteMapping(path = "/eliminar")
    public void eliminarEstudiante(String cedula){
        this.estudianteService.eliminarEstudiate(cedula);
    }

}
