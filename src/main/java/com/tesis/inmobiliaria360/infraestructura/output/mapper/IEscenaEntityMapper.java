package com.tesis.inmobiliaria360.infraestructura.output.mapper;

import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(
        componentModel = "spring",// que spring lo tome como un bean
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEscenaEntityMapper {
    EscenaEntity toEscenaEntity (Escena escena);
    Escena toEscena(EscenaEntity escenaEntity);
    List<Escena> toEscenaList(List<EscenaEntity> escenaEntityList);

}
