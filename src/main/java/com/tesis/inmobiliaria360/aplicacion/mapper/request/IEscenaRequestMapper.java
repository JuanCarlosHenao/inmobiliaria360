package com.tesis.inmobiliaria360.aplicacion.mapper.request;

import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.dominio.model.Escena;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = "spring",// que spring lo tome como un bean
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEscenaRequestMapper {
    Escena toEscena(EscenaRequestDto escenaRequestDto);
}
