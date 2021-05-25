package com.lab1.entity;


import com.lab1.dto.ComentarioDTO;
import lombok.*;

import javax.persistence.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "comment")
@Builder(builderClassName = "Builder")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comentario;

    public static Comentario DtoParaComentario(ComentarioDTO dto){
        return Comentario.builder()
                .comentario(dto.getComentario()).build();
    }

}
