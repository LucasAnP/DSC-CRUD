package com.lab1.controler;

import com.lab1.dto.DisciplinaDTO;
import com.lab1.entity.Disciplina;
import com.lab1.repository.DisciplinaRepository;
import com.lab1.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("v1/api/disciplinas")
public class DisciplinaControler {

    @Autowired
    private DisciplinaService service;

    @Autowired
    private DisciplinaRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Disciplina> disciplinas(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Disciplina postDisciplina (@RequestBody DisciplinaDTO disciplina){
        return repository.save(Disciplina.DtoParaDisciplina(disciplina));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDisciplina (@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Optional<Disciplina> getDisciplinaId(@PathVariable Long id){
        return repository.findById(id);
    }


    @PutMapping("/{id}/{nome}")
    @ResponseStatus(HttpStatus.CREATED)
    private Disciplina putNome(@PathVariable long id, @PathVariable String nome){
        return service.mudarNome(id, nome);
    }

    @PutMapping("/{id}/nota")
    @ResponseStatus(HttpStatus.CREATED)
    private Disciplina putNota (Long id, double nota) {
        return service.mudarNota(id, nota);
    }

    @GetMapping("/ranking")
    @ResponseStatus(HttpStatus.OK)
    private List<Disciplina> getRanking(){
        return service.retornaRanking();
    }





}
