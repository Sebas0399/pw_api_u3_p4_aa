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

    @GetMapping(path = "/buscar/{cedula}")
    public Estudiante getEstudianteCedula(@PathVariable String cedula) {
        return this.estudianteService.getEstudianteCedula(cedula);
    }

    @GetMapping(path = "/buscarTodo")
    public List<Estudiante> getEstudiantes(@RequestParam String provincia) {

        return this.estudianteService.getEstudiantes().stream().filter(x -> x.getProvincia().equals(provincia)).toList();
    }
    @GetMapping(path = "/buscarTodoProv")
    public List<Estudiante> getEstudiantesProv(@RequestParam String provincia) {

        return this.estudianteService.getEstudiantes(provincia);
    }

    @PostMapping(path = "/insertar")
    public void insertarEstudiante(@RequestBody Estudiante estudiante) {
        this.estudianteService.insertarEstudiante(estudiante);
    }

    @PutMapping(path = "/actualizar/{identificador}")
    public void actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        this.estudianteService.actualizarEstudiante(estudiante);
    }

    @PatchMapping(path = "/actualizarParcial/{identificador}")
    public void actualizarEstudianteParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        this.estudianteService.actualizarEstudiante(estudiante);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public void eliminarEstudiante(@PathVariable Integer id) {
        this.estudianteService.eliminarEstudiate(id);
    }

}
