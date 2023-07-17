package com.example.demo.controller;

import com.example.demo.repository.model.Materia;
import com.example.demo.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {
    @Autowired
    IMateriaService materiaService;
    @GetMapping(path = "/buscar")
    public Materia buscarMateria(){
        String nombre="Historia";
        return this.materiaService.readByNombreMateria(nombre);
    }
    @PostMapping(path = "/insertar")
    public void insertarMateria(@RequestBody Materia materia){
        this.materiaService.createMateria(materia);
    }
}