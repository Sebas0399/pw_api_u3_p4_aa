package com.example.demo.controller;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {
    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping(path = "/{cedula}")
    public ResponseEntity<Estudiante> getEstudianteCedula(@PathVariable String cedula) {
        Estudiante estudiante=this.estudianteService.getEstudianteCedula(cedula);

        return ResponseEntity.status(227).body(estudiante);
    }

    @GetMapping()
    public ResponseEntity<List<Estudiante>> getEstudiantes() {
        List<Estudiante> estudiantes=this.estudianteService.getEstudiantes();
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Detalle mensaje","Ciudadanos consultados exitosamente");
        cabeceras.add("Valor del API","Incalculable");

        return new ResponseEntity<>(estudiantes,cabeceras,228);
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
