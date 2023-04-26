package com.tesis.inmobiliaria360.aplicacion.mapper.response;


import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.dominio.model.Escena;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",// que spring lo tome como un bean
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEscenaResponseMapper {
    EscenaResponseDto toEscenaDto(Escena escena);
    List<EscenaResponseDto> toEscenaResponseDtoList(List<Escena> escenaList);
}
