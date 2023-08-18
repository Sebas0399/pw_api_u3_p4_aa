package com.example.demo.controller;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.model.Materia;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin
public class EstudianteControllerRestFul {
    @Autowired
    private IEstudianteService estudianteService;

    @Autowired
    private IMateriaService materiaService;

    @GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Estudiante getEstudianteCedula(@PathVariable String cedula) {
        Estudiante estudiante = this.estudianteService.getEstudianteCedula(cedula);

        return (estudiante);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstudianteTO>> getEstudiantesHATEOAS() {
        List<EstudianteTO> estudiantes = this.estudianteService.getEstudiantesTO();
        if (estudiantes.isEmpty()) {
            return new ResponseEntity<>(null, null, 400);

        } else {
            for (EstudianteTO e : estudiantes) {
                Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class).buscarPorEstudiante(e.getCedula())).withRel("materias");
                e.add(myLink);
            }
            return new ResponseEntity<>(estudiantes, null, 200);
        }
    }

    @GetMapping(path = "/{cedula}/materias")
    public ResponseEntity<List<MateriaTO>> buscarPorEstudiante(@PathVariable String cedula) {
        
        return new ResponseEntity<>(this.materiaService.readByCedulaEstudiante(cedula),null,200);
    }

    @GetMapping(path = "/buscarProv")
    public List<Estudiante> getEstudiantesProv(@RequestParam String provincia) {

        return this.estudianteService.getEstudiantes(provincia);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertarEstudiante(@RequestBody Estudiante estudiante) {
        this.estudianteService.insertarEstudiante(estudiante);
    }


    @PutMapping(path = "/{identificador}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        this.estudianteService.actualizarEstudiante(estudiante);
    }

    @PatchMapping(path = "/{identificador}")
    public void actualizarEstudianteParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        this.estudianteService.actualizarEstudiante(estudiante);
    }

    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Estudiante eliminarEstudiante(@PathVariable Integer id) {
        Estudiante est=this.estudianteService.getEstudianteId(id);
        this.estudianteService.eliminarEstudiate(id);
        return est;
    }

}
