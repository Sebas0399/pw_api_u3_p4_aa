package com.example.demo.repository;

import com.example.demo.repository.model.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
}