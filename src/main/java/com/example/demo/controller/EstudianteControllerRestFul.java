package com.example.demo.controller;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
