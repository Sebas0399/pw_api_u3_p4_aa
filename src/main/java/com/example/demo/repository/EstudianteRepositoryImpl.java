package com.example.demo.repository;

import com.example.demo.repository.model.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Estudiante getEstudianteCedula(String cedula) {
        TypedQuery<Estudiante>myQuery=this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:cedula", Estudiante.class);
        myQuery.setParameter("cedula",cedula);
        return myQuery.getSingleResult();
    }
}
