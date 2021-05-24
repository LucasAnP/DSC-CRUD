package com.lab1.dto;

import com.lab1.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Builder(builderClassName = "Builder")
@Getter
@Setter
@AllArgsConstructor

public class DisciplinaDTO implements Serializable {

    private Long id;
    private String nome;
    private double nota;

    public static DisciplinaDTO DisciplinasParaDTO(Disciplina disciplina) {
        return DisciplinaDTO.builder()
                .id(disciplina.getId())
                .nome(disciplina.getNome())
                .nota(disciplina.getNota()).build();
    }

    public static List<DisciplinaDTO> DisciplinasParaDTOAll(List<Disciplina>ListaDeDisciplinas){
        return ListaDeDisciplinas.stream().map(DisciplinaDTO::DisciplinasParaDTO).collect(Collectors.toList());
    }
}
