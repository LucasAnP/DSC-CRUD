package com.lab1.dto;

import com.lab1.entity.Comentario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(builderClassName = "Builder")
@Getter
@Setter
@AllArgsConstructor
public class ComentarioDTO {

    private long id;
    private String comentario;

    public static ComentarioDTO ComentarioParaDTO(Comentario comentario){
        return ComentarioDTO.builder()
                .id(comentario.getId())
                .comentario(comentario.getComentario()).build();
    }


}
