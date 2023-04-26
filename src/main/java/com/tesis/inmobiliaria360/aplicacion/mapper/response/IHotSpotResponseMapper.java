package com.tesis.inmobiliaria360.aplicacion.mapper.response;


import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.HotSpotResponseDto;
import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.dominio.model.HotSpot;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",// que spring lo tome como un bean
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IHotSpotResponseMapper {
    HotSpotResponseDto toHotSpotDto(HotSpot hotSpot);
    List<HotSpotResponseDto> toHotSpotResponseDtoList(List<HotSpot> hotSpotList);
}
