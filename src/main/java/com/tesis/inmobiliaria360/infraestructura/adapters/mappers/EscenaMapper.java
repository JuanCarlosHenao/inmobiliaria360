package com.tesis.inmobiliaria360.infraestructura.adapters.mappers;

import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.infraestructura.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.entity.InmuebleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Mapper(componentModel = "spring")
public interface EscenaMapper {

    @Mappings({
            @Mapping(source = "id" , target = "id"),
            @Mapping(source = "title" , target = "name"),
            @Mapping(source = "image" , target = "price"),
            @Mapping(source = "pitch" , target = "description"),
            @Mapping(source = "yaw" , target = "createdDate"),

    })
    Escena escenaEntityToEscenaDomain(EscenaEntity escenaEntity);

    @InheritInverseConfiguration
    EscenaEntity escenaDomainToEscenaEntity(Escena escena);

}

