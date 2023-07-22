package com.example.demo.service;

import com.example.demo.repository.model.Horario;

import java.util.List;

public interface IHorarioService {
    public List<Horario> readAll();
    public Horario read(Integer id);

    public Horario create(Horario horario);
    public void update(Horario horario);
    public void delete(Integer id);
}
