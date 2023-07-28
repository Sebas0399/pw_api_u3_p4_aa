package com.example.demo.service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.model.Materia;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MateriaServiceImpl implements IMateriaService{
    @Autowired
    private IMateriaRepository materiaRepository;
    @Override
    public void createMateria(Materia materia) {
        this.materiaRepository.create(materia);
    }

    @Override
    public Materia readByNombreMateria(String nombre) {
        return this.materiaRepository.readByNombre(nombre);
    }

    @Override
    public List<MateriaTO> readByCedulaEstudiante(String cedula) {
        List<Materia> materias = this.materiaRepository.readByCedulaEstudiante(cedula);

        return materias.stream().map(materia -> convertir(materia)).collect(Collectors.toList());
    }

    @Override
    public MateriaTO readById(Integer id) {
        Materia materia=this.materiaRepository.readById(id);

        return convertir(materia);
    }

    public MateriaTO convertir(Materia materia) {
        MateriaTO materiaTO = new MateriaTO();
        materiaTO.setId(materia.getId());
        materiaTO.setNombre(materia.getNombre());
        materiaTO.setNumeroCreditos(materia.getNumeroCreditos());

        return materiaTO;
    }
}