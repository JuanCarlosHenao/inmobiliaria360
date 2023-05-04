package com.tesis.inmobiliaria360.infraestructura.output.mapper;

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
//        unmappedSourcePolicy = ReportingPolicy.IGNORE
//)
@Mapper(componentModel = "spring")
public interface IEscenaEntityMapper {

    @Mappings({
            @Mapping(source = "id" , target = "id"),
            @Mapping(source = "inmueble" , target = "inmueble"),
            @Mapping(source = "title" , target = "title"),
            @Mapping(source = "image" , target = "image"),
            @Mapping(source = "pitch" , target = "pitch"),
            @Mapping(source = "yaw" , target = "yaw"),
//            @Mapping(source = "hotSpotEntityList" , target = "hotSpotList")
    })
    EscenaEntity toEscenaEntity (Escena escena);
    Escena toEscena(EscenaEntity escenaEntity);
    List<Escena> toEscenaList(List<EscenaEntity> escenaEntityList);


//    @Mappings({
//            @Mapping(source = "id" , target = "id"),
//            @Mapping(source = "title" , target = "name"),
//            @Mapping(source = "image" , target = "price"),
//            @Mapping(source = "pitch" , target = "description"),
//            @Mapping(source = "yaw" , target = "createdDate"),
//
//    })
//    Escena escenaEntityToEscenaDomain(EscenaEntity escenaEntity);
//
//    @InheritInverseConfiguration
//    EscenaEntity escenaDomainToEscenaEntity(Escena escena);

}
