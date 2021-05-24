package com.lab1.entity;

import com.lab1.dto.DisciplinaDTO;
import lombok.*;

import java.io.Serializable;

@Builder(builderClassName = "Builder")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Disciplina implements Serializable {

    private long id;
    private String nome;
    private double nota;

    public static Disciplina DtoParaDisciplina(DisciplinaDTO dto) {
        return Disciplina.builder()
                .nome(dto.getNome())
                    .nota(dto.getNota()).build();
    }
}
