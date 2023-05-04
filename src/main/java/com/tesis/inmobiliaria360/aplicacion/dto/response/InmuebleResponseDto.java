package com.tesis.inmobiliaria360.aplicacion.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InmuebleResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String image;
    private LocalDateTime createdDate;
    private List<EscenaResponseDto> escenaResponseDtoList;
}
