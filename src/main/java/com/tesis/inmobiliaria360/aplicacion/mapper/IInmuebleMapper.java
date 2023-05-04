package com.tesis.inmobiliaria360.aplicacion.mapper;


import com.tesis.inmobiliaria360.aplicacion.dto.request.InmuebleRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.InmuebleResponseDto;
import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IInmuebleMapper {
    @Mappings({
            @Mapping(source = "name" , target = "name"),
            @Mapping(source = "price" , target = "price"),
            @Mapping(source = "description" , target = "description"),
            @Mapping(source = "image" , target = "image"),
            @Mapping(source = "createdDate" , target = "createdDate"),
            @Mapping(source = "escenaRequestDtoList" , target = "escenaList")

    })
    Inmueble inmuebleDtoRequestToInmuebleDomain(InmuebleRequestDto inmuebleRequestDto);

    @InheritInverseConfiguration
    InmuebleResponseDto inmuebleDomainToInmuebleDtoResponse(Inmueble inmueble);

    List<InmuebleResponseDto> inmuebleDomainListToInmuebleDtoResponseList(List<Inmueble> inmuebleList);


}
