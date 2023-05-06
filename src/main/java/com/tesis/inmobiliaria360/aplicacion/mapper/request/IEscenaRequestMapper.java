package com.tesis.inmobiliaria360.aplicacion.mapper.request;

import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.dominio.model.Escena;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;


//@Mapper(
//        componentModel = "spring",// que spring lo tome como un bean
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
//        unmappedSourcePolicy = ReportingPolicy.IGNORE)

@Mapper(componentModel = "spring")
public interface IEscenaRequestMapper {

//    @Mappings({
//            @Mapping(source = "title" , target = "title"),
//            @Mapping(source = "image" , target = "image"),
//            @Mapping(source = "pitch" , target = "pitch"),
//            @Mapping(source = "yaw" , target = "yaw"),
//            @Mapping(source = "hotSpotRequestDtoList" , target = "hotSpotList")
//    })
    Escena toEscena(EscenaRequestDto escenaRequestDto);
}
