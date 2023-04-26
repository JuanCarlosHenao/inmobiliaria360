package com.tesis.inmobiliaria360.infraestructura.output.mapper;

import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.dominio.model.HotSpot;
import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.output.entity.HotSpotEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",// que spring lo tome como un bean
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IHotSpotEntityMapper {
    HotSpotEntity toHotSpotEntity (HotSpot hotSpot);
    HotSpot toHotSpot(HotSpotEntity hotSpotEntity);
    List<HotSpot> toHotSpotList(List<HotSpotEntity> hotSpotEntityList);
}
