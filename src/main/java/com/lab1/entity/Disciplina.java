package com.lab1.entity;

import com.lab1.dto.DisciplinaDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "course")
@Builder(builderClassName = "Builder")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(unique = true)
    private String nome;


    private double nota;
    private long like = 0;
    @ManyToMany(cascade = CascadeType.DETACH)
    @PrimaryKeyJoinColumn
    private Set<Comentario> comentarios = new HashSet<>();

    public static Disciplina DtoParaDisciplina(DisciplinaDTO dto) {
        return Disciplina.builder()
                .nome(dto.getNome())
                .nota(dto.getNota())
                .like(dto.getLike())
                .comentarios(dto.getComentarios())
                .build();
    }
}