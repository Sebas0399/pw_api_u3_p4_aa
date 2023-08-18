package com.example.demo.repository;

import com.example.demo.repository.model.Materia;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void create(Materia materia) {
        this.entityManager.persist(materia);
    }

    @Override
    public Materia readByNombre(String nombre) {
        TypedQuery<Materia>myQuery=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.nombre=:nombre",Materia.class);
        myQuery.setParameter("nombre",nombre);
        return myQuery.getSingleResult();
    }

    @Override
    public List<Materia> readByCedulaEstudiante(String cedula) {
        TypedQuery<Materia>myQuery=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.cedula=:cedula",Materia.class);
        myQuery.setParameter("cedula",cedula);
        return myQuery.getResultList();
    }

    @Override
    public Materia readById(Integer id) {
        return this.entityManager.find(Materia.class,id);
    }
}