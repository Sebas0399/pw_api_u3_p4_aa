package com.example.demo.controller;

import com.example.demo.repository.model.Materia;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.MateriaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {
    @Autowired
    IMateriaService materiaService;
    @GetMapping(path = "/{id}")
    public ResponseEntity<MateriaTO> buscarMateria(@PathVariable Integer id){
        MateriaTO materiaTO=this.materiaService.readById(id);
        Link myLink=linkTo(methodOn(MateriaControllerRestFul.class).buscarMateria(id)).withRel("materia");
        materiaTO.add(myLink);
        return ResponseEntity.status(HttpStatus.OK).body(materiaTO);
    }
    @PostMapping(path = "/insertar")
    public void insertarMateria(@RequestBody Materia materia){
        this.materiaService.createMateria(materia);
    }
}