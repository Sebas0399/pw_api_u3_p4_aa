package com.example.demo.service;

import com.example.demo.repository.IHorarioRepository;
import com.example.demo.repository.model.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HorarioServiceImpl implements IHorarioService{
    @Autowired
    private IHorarioRepository horarioRepository;
    @Override
    public List<Horario> readAll() {
        return this.horarioRepository.readAll();
    }

    @Override
    public Horario read(Integer id) {
        return this.horarioRepository.read(id);
    }

    @Override
    public Horario create(Horario horario) {
        return this.horarioRepository.create(horario);
    }

    @Override
    public void update(Horario horario) {
        this.horarioRepository.update(horario);
    }

    @Override
    public void delete(Integer id) {
        this.horarioRepository.delete(id);
    }
}
