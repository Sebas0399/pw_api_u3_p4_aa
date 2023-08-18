package com.example.demo.repository;

import com.example.demo.repository.model.Estudiante;
import javax.persistence.*;
import javax.transaction.Transactional;

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
    public Estudiante getEstudianteId(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> getEstudiantes() {

        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e ORDER BY e.id ASC ", Estudiante.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> getEstudiantes(String provincia) {
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.provincia=:provincia", Estudiante.class);
        myQuery.setParameter("provincia",provincia);
        return myQuery.getResultList();    }

    @Override
    public void eliminarEstudiate(String cedula) {
        Estudiante est = this.getEstudianteCedula(cedula);
        this.entityManager.remove(est);
    }

    @Override
    public void eliminarEstudiate(Integer id) {
        Estudiante estudiante = this.getEstudianteId(id);
        this.entityManager.remove(estudiante);
    }

    @Override
    public void insertarEstudiante(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {

        this.entityManager.merge(estudiante);
    }

    @Override
    public void actualizarParcial(String cedulaActual, String cedulaNueva) {
        Query myQuery = this.entityManager.createQuery("UPDATE Estudiante e SET e.cedula=:datoCedula WHERE e.cedula=:datoCondicion");
        myQuery.setParameter("datoCedula", cedulaNueva);
        myQuery.setParameter("datoCondicion", cedulaActual);
        myQuery.executeUpdate();


    }
}
