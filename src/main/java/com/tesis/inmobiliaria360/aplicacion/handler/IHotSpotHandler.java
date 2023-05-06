package com.tesis.inmobiliaria360.aplicacion.handler;

import com.tesis.inmobiliaria360.aplicacion.dto.request.HotSpotRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.HotSpotResponseDto;
import com.tesis.inmobiliaria360.dominio.model.HotSpot;

import java.util.List;

public interface IHotSpotHandler {

    HotSpotResponseDto saveHotSpot ( HotSpotRequestDto hotSpotRequestDto);
    List<HotSpotResponseDto> getAllHotSpots();

    HotSpotResponseDto getHotSpotById(Long id);
    List<HotSpotResponseDto> getAllHotSpotByEscenaId(Long escenaId);

}
