package com.example.demo.controller;

import com.example.demo.repository.model.Materia;
import com.example.demo.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {
    @Autowired
    IMateriaService materiaService;
    @GetMapping(path = "/{nombre}")
    public ResponseEntity<Materia> buscarMateria(@PathVariable String nombre){
        Materia materia=this.materiaService.readByNombreMateria(nombre);
        return ResponseEntity.status(HttpStatus.OK).body(materia);
    }
    @PostMapping(path = "/insertar")
    public void insertarMateria(@RequestBody Materia materia){
        this.materiaService.createMateria(materia);
    }
}