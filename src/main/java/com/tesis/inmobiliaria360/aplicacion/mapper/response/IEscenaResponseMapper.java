package com.tesis.inmobiliaria360.aplicacion.mapper.response;


import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

//@Mapper(
//        componentModel = "spring",// que spring lo tome como un bean
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
//        unmappedSourcePolicy = ReportingPolicy.IGNORE)
@Mapper(componentModel = "spring")
public interface IEscenaResponseMapper {
    @Mappings({
            @Mapping(source = "title" , target = "title"),
            @Mapping(source = "image" , target = "image"),
            @Mapping(source = "pitch" , target = "pitch"),
            @Mapping(source = "yaw" , target = "yaw"),
//            @Mapping(source = "inmueble" , target = "inmueble")
//            @Mapping(source = "hotSpotDtoRequestList" , target = "hotSpotList")
    })
    EscenaResponseDto toEscenaDto(Escena escena);
    List<EscenaResponseDto> toEscenaResponseDtoList(List<Escena> escenaList);

    EscenaEntity escenaDomainToEscenaEntity(Escena escena);
}
