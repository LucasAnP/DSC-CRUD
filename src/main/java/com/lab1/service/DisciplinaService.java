package com.lab1.service;

import com.lab1.entity.Disciplina;
import com.lab1.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    List<Disciplina> disciplinas = new ArrayList<>();
    static private long incrementador = 1;

    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> retornaRanking() {
        List<Disciplina> disciplinasRanking = this.disciplinas;
        disciplinasRanking.sort((d1,d2) -> Double.compare(d1.getNota(),d2.getNota()));

        return disciplinasRanking;
    }

    public Disciplina mudarNome (Long id, String name) {
        return repository.findById(id).map(disciplina ->{
            disciplina.setNome(name);
            return repository.save(disciplina);
        } ).orElseThrow(()->new EmptyResultDataAccessException(1));
    }

    public Disciplina mudarNota (Long id, Double nota){
        return repository.findById(id).map(disciplina ->{
            disciplina.setNota(nota);
            return repository.save(disciplina);
        } ).orElseThrow(()->new EmptyResultDataAccessException(1));
    }
}
