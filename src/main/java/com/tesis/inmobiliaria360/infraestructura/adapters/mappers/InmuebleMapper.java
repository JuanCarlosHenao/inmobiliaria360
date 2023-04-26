package com.tesis.inmobiliaria360.infraestructura.adapters.mappers;

import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import com.tesis.inmobiliaria360.infraestructura.entity.InmuebleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {EscenaMapper.class})
public interface InmuebleMapper {
    @Mappings({
            @Mapping(source = "id" , target = "id"),
            @Mapping(source = "name" , target = "name"),
            @Mapping(source = "price" , target = "price"),
            @Mapping(source = "description" , target = "description"),
            @Mapping(source = "createdDate" , target = "createdDate"),
            @Mapping(source = "escenaEntityList" , target = "escenaList")

    })
    Inmueble inmuebleEntityToInmuebleDomain(InmuebleEntity inmuebleEntity);

    @InheritInverseConfiguration
    InmuebleEntity inmuebleDomainToInmuebleEntity(Inmueble inmueble);
}
