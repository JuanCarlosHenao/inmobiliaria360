package com.tesis.inmobiliaria360.aplicacion.dto.response;


import lombok.*;

import java.util.List;


@Data
public class EscenaResponseDto {
    private Long id;
    private String title;
    private String image;
    private Double pitch;
    private Double yaw;
    private List<HotSpotResponseDto> hotSpotResponseDtoList;

}
