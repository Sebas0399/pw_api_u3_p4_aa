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

    @GetMapping(path = "/{cedula}")
    public Estudiante getEstudianteCedula(@PathVariable String cedula) {
        return this.estudianteService.getEstudianteCedula(cedula);
    }

    @GetMapping()
    public List<Estudiante> getEstudiantes() {

        return this.estudianteService.getEstudiantes();
    }
    @GetMapping(path = "/buscarProv")
    public List<Estudiante> getEstudiantesProv(@RequestParam String provincia) {

        return this.estudianteService.getEstudiantes(provincia);
    }

    @PostMapping
    public void insertarEstudiante(@RequestBody Estudiante estudiante) {
        this.estudianteService.insertarEstudiante(estudiante);
    }

    @PutMapping(path = "/{identificador}")
    public void actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        this.estudianteService.actualizarEstudiante(estudiante);
    }

    @PatchMapping(path = "/{identificador}")
    public void actualizarEstudianteParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        this.estudianteService.actualizarEstudiante(estudiante);
    }

    @DeleteMapping(path = "/{id}")
    public void eliminarEstudiante(@PathVariable Integer id) {
        this.estudianteService.eliminarEstudiate(id);
    }

}
