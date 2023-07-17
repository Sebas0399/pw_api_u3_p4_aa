package com.example.demo.repository;

import com.example.demo.repository.model.Horario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class HorarioRepositoryImpl implements  IHorarioRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Horario> readAll() {
        TypedQuery<Horario>myQuery=this.entityManager.createQuery("SELECT h FROM Horario h",Horario.class);

        return myQuery.getResultList() ;
    }

    @Override
    public Horario read(Integer id) {
        return this.entityManager.find(Horario.class,id);
    }

    @Override
    public void create(Horario horario) {
        this.entityManager.persist(horario);
    }

    @Override
    public void update(Horario horario) {
        this.entityManager.merge(horario);
    }

    @Override
    public void delete(Integer id) {
        Horario horario=this.read(id);
        this.entityManager.remove(horario);
    }
}
