package com.example.demo.repository;

import com.example.demo.repository.model.Horario;

import java.util.List;

public interface IHorarioRepository {
    public List<Horario> readAll();
    public Horario read(Integer id);

    public void create(Horario horario);
    public void update(Horario horario);
    public void delete(Integer id);

}
