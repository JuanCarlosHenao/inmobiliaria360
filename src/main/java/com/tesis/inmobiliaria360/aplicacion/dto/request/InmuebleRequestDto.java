package com.tesis.inmobiliaria360.aplicacion.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InmuebleRequestDto {
    private String name;
    private Double price;
    private String description;
    private String image;
    private LocalDateTime createdDate = LocalDateTime.now();
    private List<EscenaRequestDto> escenaRequestDtoList;
}
