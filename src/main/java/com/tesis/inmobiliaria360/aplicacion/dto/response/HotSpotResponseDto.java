package com.tesis.inmobiliaria360.aplicacion.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class HotSpotResponseDto {
    private Long id;
    private String name ;
    private String type;
    private Double pitch;
    private Double yaw;
    private String cssClass;
    private String nextScene;
    // acá iríala lista de escenas o el id de la escena a la cuál pertenece
}
