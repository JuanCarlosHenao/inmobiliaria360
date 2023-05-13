package com.tesis.inmobiliaria360.aplicacion.handler.impl;


import com.tesis.inmobiliaria360.aplicacion.dto.request.HotSpotRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.HotSpotResponseDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.InmuebleResponseDto;
import com.tesis.inmobiliaria360.aplicacion.handler.IEscenaHandler;
import com.tesis.inmobiliaria360.aplicacion.handler.IHotSpotHandler;
import com.tesis.inmobiliaria360.aplicacion.mapper.request.IHotSpotRequestMapper;
import com.tesis.inmobiliaria360.aplicacion.mapper.response.IHotSpotResponseMapper;
import com.tesis.inmobiliaria360.dominio.api.IEscenaServicePort;
import com.tesis.inmobiliaria360.dominio.api.IHotSpotServicePort;
import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.dominio.model.HotSpot;
import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // porque manipula y tiene lógica para los datos
@RequiredArgsConstructor // porque requiere usar todas las interfaces

//@Transactional  // para la parte transaccional de agregar las diferentes escenas
public class HotSpotHandler implements IHotSpotHandler {
    private final IHotSpotServicePort hotSpotServicePort;
    private final IHotSpotRequestMapper hotSpotRequestMapper;
    private final IHotSpotResponseMapper hotSpotResponseMapper;
    private final IEscenaServicePort iEscenaServicePort ;


    @Override
    public HotSpotResponseDto saveHotSpot(HotSpotRequestDto hotSpotRequestDto) {
        Escena escena =  iEscenaServicePort.getEscenaById(hotSpotRequestDto.getEscena_id());
        HotSpot hotSpot = hotSpotRequestMapper.toHotSpot(hotSpotRequestDto);
        hotSpot.setEscena(escena);
        return hotSpotResponseMapper.toHotSpotResponseDto(hotSpotServicePort.saveHotSpot(hotSpot));

    }

    @Override
    public List<HotSpotResponseDto> getAllHotSpots() {
        return hotSpotResponseMapper.toHotSpotResponseDtoList(hotSpotServicePort.getAllHotSpots());
    }

    @Override
    public HotSpotResponseDto getHotSpotById(Long id) {
        return hotSpotResponseMapper.toHotSpotResponseDto(hotSpotServicePort.getHotSpotById(id));
    }

    @Override
    public List<HotSpotResponseDto> getAllHotSpotByEscenaId(Long escenaId) {
        return hotSpotResponseMapper.toHotSpotResponseDtoList(hotSpotServicePort.getAllHotSpotByEscenaId(escenaId));
    }

    @Override
    public void updateHotSpot(Long id, HotSpotRequestDto hotSpotRequestDto) {

        HotSpotResponseDto hotSpotAActualizar = getHotSpotById(id);
        Escena escena =  iEscenaServicePort.getEscenaById(hotSpotRequestDto.getEscena_id());
        hotSpotAActualizar.setName(hotSpotRequestDto.getName());
        hotSpotAActualizar.setType(hotSpotRequestDto.getType());
        hotSpotAActualizar.setPitch(hotSpotRequestDto.getPitch());
        hotSpotAActualizar.setYaw(hotSpotRequestDto.getYaw());
        hotSpotAActualizar.setCssClass(hotSpotRequestDto.getCssClass());
        hotSpotAActualizar.setNextScene(hotSpotRequestDto.getNextScene());

        HotSpot hotSpot = hotSpotResponseMapper.hotSpotResponseDtoToHotSpotDomain(hotSpotAActualizar);
        hotSpot.setEscena(escena);
        hotSpotServicePort.updateHotSpot(hotSpot);



    }
}
