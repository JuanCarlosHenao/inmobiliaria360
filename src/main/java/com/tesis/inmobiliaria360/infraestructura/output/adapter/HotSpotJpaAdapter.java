package com.tesis.inmobiliaria360.infraestructura.output.adapter;


import com.tesis.inmobiliaria360.aplicacion.dto.response.HotSpotResponseDto;
import com.tesis.inmobiliaria360.dominio.model.HotSpot;
import com.tesis.inmobiliaria360.dominio.spi.IHotSpotPersistencePort;
import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.output.entity.HotSpotEntity;
import com.tesis.inmobiliaria360.infraestructura.output.mapper.IHotSpotEntityMapper;
import com.tesis.inmobiliaria360.infraestructura.output.repository.IHotSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
public class HotSpotJpaAdapter implements IHotSpotPersistencePort { // INVERSION DE DEPENDENCIAS

    private final IHotSpotRepository hotSpotRepository;
    private final IHotSpotEntityMapper hotSpotEntityMapper;


    @Override
    public HotSpot saveHotSpot(HotSpot hotSpot) {
        HotSpotEntity hotSpotEntity =hotSpotRepository.save(hotSpotEntityMapper.hotSpotDomaintoHotSpotEntity(hotSpot));
        return hotSpotEntityMapper.hotSpotEntitytoHotSpotDomain(hotSpotEntity);
    }

    @Override
    public List<HotSpot> getAllHotSpots() {
        List<HotSpotEntity> hotSpotEntityList  = hotSpotRepository.findAll();
        // añadir excepcion si no hay datos
        return hotSpotEntityMapper.hotSpotEntityListtoHotSpotDomainList(hotSpotEntityList);
    }

    @Override
    public HotSpot getHotSpotById(Long id) {
        try {
            return hotSpotEntityMapper.hotSpotEntitytoHotSpotDomain(hotSpotRepository.findById(id).get());
        } catch (Exception e){
        }
        return null;
    }

    @Override
    public List<HotSpot> getAllHotSpotByEscenaId(Long escenaId) {
        try {
            return hotSpotEntityMapper.hotSpotEntityListtoHotSpotDomainList(hotSpotRepository.findHotSpotEntityByEscenaId(escenaId));
        } catch (Exception e){
        }
        return null;
    }
}
