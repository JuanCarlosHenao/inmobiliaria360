package com.tesis.inmobiliaria360.aplicacion.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EscenaRequestDto {
    private String inmueble_id;
    private String title;
    private String image;
    private Double pitch;
    private Double yaw;
}
