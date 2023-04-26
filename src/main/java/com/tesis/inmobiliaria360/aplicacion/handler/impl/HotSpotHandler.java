package com.tesis.inmobiliaria360.aplicacion.handler.impl;


import com.tesis.inmobiliaria360.aplicacion.dto.request.HotSpotRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.HotSpotResponseDto;
import com.tesis.inmobiliaria360.aplicacion.handler.IHotSpotHandler;
import com.tesis.inmobiliaria360.aplicacion.mapper.request.IHotSpotRequestMapper;
import com.tesis.inmobiliaria360.aplicacion.mapper.response.IHotSpotResponseMapper;
import com.tesis.inmobiliaria360.dominio.api.IHotSpotServicePort;
import com.tesis.inmobiliaria360.dominio.model.HotSpot;

import java.util.List;

//@RequiredArgsConstructor // porque requiere usar todas las interfaces
//@Service // porque manipula y tiene lógica para los datos
//@Transactional  // para la parte transaccional de agregar las diferentes escenas
public class HotSpotHandler implements IHotSpotHandler {
    private final IHotSpotServicePort hotSpotServicePort;
    private final IHotSpotRequestMapper hotSpotRequestMapper;
    private final IHotSpotResponseMapper hotSpotResponseMapper;

    public HotSpotHandler(IHotSpotServicePort hotSpotServicePort, IHotSpotRequestMapper hotSpotRequestMapper, IHotSpotResponseMapper hotSpotResponseMapper) {
        this.hotSpotServicePort = hotSpotServicePort;
        this.hotSpotRequestMapper = hotSpotRequestMapper;
        this.hotSpotResponseMapper = hotSpotResponseMapper;
    }

    @Override
    public void saveHotSpot(HotSpotRequestDto hotSpotRequestDto) {
        HotSpot hotSpot = hotSpotRequestMapper.toHotSpot(hotSpotRequestDto);
        hotSpotServicePort.saveHotSpot(hotSpot);
    }

    @Override
    public List<HotSpotResponseDto> getAllHotSpots() {
        return hotSpotResponseMapper.toHotSpotResponseDtoList(hotSpotServicePort.getAllHotSpots());
    }
}
