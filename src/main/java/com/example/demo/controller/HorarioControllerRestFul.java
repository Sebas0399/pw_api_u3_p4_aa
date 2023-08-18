package com.example.demo.controller;

import com.example.demo.repository.model.Horario;
import com.example.demo.service.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/horarios")
@RestController
@CrossOrigin

public class HorarioControllerRestFul {
    @Autowired
    private IHorarioService horarioService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Horario> obtenerTodos(){
        return this.horarioService.readAll();
    }
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public Horario insertar(@RequestBody Horario horario){
        return this.horarioService.create(horario);
    }
    @PutMapping(path = "/{id}")
    public void actualizar(@RequestBody  Horario horario, @PathVariable Integer id){
        horario.setId(id);
        this.horarioService.update(horario);
    }
    @PatchMapping(path = "/{id}")
    public void actualizarParcial(@RequestBody  Horario horario, @PathVariable Integer id){
        horario.setId(id);
        this.horarioService.update(horario);
    }
    @DeleteMapping(path = "/{id}")
    public void eliminar(@PathVariable Integer id){
        this.horarioService.delete(id);
    }

}
