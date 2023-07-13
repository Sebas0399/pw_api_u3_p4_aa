package com.example.demo.repository;

import com.example.demo.repository.model.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante getEstudianteCedula(String cedula) {
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:cedula", Estudiante.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getSingleResult();
    }

    @Override
    public List<Estudiante> getEstudiantes() {

        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e ", Estudiante.class);
        return myQuery.getResultList();
    }

    @Override
    public void eliminarEstudiate(String cedula) {
        Estudiante est= this.getEstudianteCedula(cedula);
        this.entityManager.remove(est);
    }

    @Override
    public void insertarEstudiante(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        Estudiante est=this.getEstudianteCedula(estudiante.getCedula());
        est.setApellido(estudiante.getApellido());
        est.setNombre(estudiante.getNombre());
        est.setFechaNacimiento(est.getFechaNacimiento());
        this.entityManager.merge(estudiante);
    }
}
