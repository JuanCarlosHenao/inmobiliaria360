package com.tesis.inmobiliaria360.infraestructura.output.mapper;


import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.output.entity.InmuebleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IEscenaEntityMapper.class})
//@Mapper(componentModel = "spring")
public interface IInmuebleEntityMapper {
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

    List<Inmueble> inmuebleEntityListToInmuebleDomainList(List<InmuebleEntity> inmuebleEntityList);
}
