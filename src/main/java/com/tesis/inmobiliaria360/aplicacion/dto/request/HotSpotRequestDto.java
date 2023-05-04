package com.tesis.inmobiliaria360.aplicacion.dto.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class HotSpotRequestDto {
    private Long escena_id;
    private String name ;
    private String type;
    private Double pitch;
    private Double yaw;
    private String cssClass;
    private String nextScene;
}
