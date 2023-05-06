package com.tesis.inmobiliaria360.aplicacion.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class EscenaRequestDto {
    private Long inmueble_id;
    private String title;
    private String image;
    private Double pitch;
    private Double yaw;
    private List<HotSpotRequestDto> hotSpotRequestDtoList;
}
