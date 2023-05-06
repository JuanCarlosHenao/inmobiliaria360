package com.tesis.inmobiliaria360.aplicacion.handler.impl;

import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.HotSpotResponseDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.InmuebleResponseDto;
import com.tesis.inmobiliaria360.aplicacion.handler.IEscenaHandler;
import com.tesis.inmobiliaria360.aplicacion.handler.IHotSpotHandler;
import com.tesis.inmobiliaria360.aplicacion.mapper.request.IEscenaRequestMapper;
import com.tesis.inmobiliaria360.aplicacion.mapper.response.IEscenaResponseMapper;
import com.tesis.inmobiliaria360.dominio.api.IEscenaServicePort;
import com.tesis.inmobiliaria360.dominio.api.IInmuebleServicePort;
import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor // porque requiere usar todas las interfaces
// porque manipula y tiene lógica para los datos
//@Transactional  // para la parte transaccional de agregar las diferentes escenas
public class EscenaHandler implements IEscenaHandler {
    private final IInmuebleServicePort iInmuebleServicePort;
    private final IEscenaServicePort escenaServicePort;
    private final IEscenaRequestMapper escenaRequestMapper;
    private final IEscenaResponseMapper escenaResponseMapper;
    private final IHotSpotHandler iHotSpotHandler;

//    public EscenaHandler(IEscenaServicePort escenaServicePort, IEscenaRequestMapper escenaRequestMapper, IEscenaResponseMapper escenaResponseMapper) {
//        this.escenaServicePort = escenaServicePort;
//        this.escenaRequestMapper = escenaRequestMapper;
//        this.escenaResponseMapper = escenaResponseMapper;
//    }

    @Override
    public void saveEscena(EscenaRequestDto escenaRequestDto) {
        Inmueble inmueble = iInmuebleServicePort.obtenerInmueble(escenaRequestDto.getInmueble_id());
        Escena escena=escenaRequestMapper.toEscena(escenaRequestDto);
        escena.setInmueble(inmueble);
        escenaServicePort.saveEscena(escena);
    }

    @Override
    public List<EscenaResponseDto> getAllEscenas() {
//        return escenaResponseMapper.toEscenaResponseDtoList(escenaServicePort.getAllEscenas()) ;


        List<HotSpotResponseDto> hotSpotResponseDtoList = new ArrayList<>();
        List<EscenaResponseDto> escenaResponseDtoList = escenaResponseMapper.toEscenaResponseDtoList(escenaServicePort.getAllEscenas());

        for (EscenaResponseDto escenaResponseDtoItem:escenaResponseDtoList) {
            escenaResponseDtoItem.setHotSpotResponseDtoList(iHotSpotHandler.getAllHotSpotByEscenaId(escenaResponseDtoItem.getId()));
        }
        return escenaResponseDtoList;
    }

    @Override
    public EscenaResponseDto getEscenaById(Long id) {
        List<HotSpotResponseDto> hotSpotResponseDtoList = new ArrayList<>();
        hotSpotResponseDtoList = iHotSpotHandler.getAllHotSpotByEscenaId(id);
        EscenaResponseDto escenaResponseDto = escenaResponseMapper.toEscenaDto(escenaServicePort.getEscenaById(id));
        escenaResponseDto.setHotSpotResponseDtoList(hotSpotResponseDtoList);
        return escenaResponseDto;
    }

    @Override
    public List<EscenaResponseDto> getAllEscenasByInmuebleId(Long id) {
//        return escenaResponseMapper.toEscenaResponseDtoList(escenaServicePort.getAllEscenasByInmuebleId(id));

        List<HotSpotResponseDto> hotSpotResponseDtoList = new ArrayList<>();
        List<EscenaResponseDto> escenaResponseDtoList = escenaResponseMapper.toEscenaResponseDtoList(escenaServicePort.getAllEscenasByInmuebleId(id));

        for (EscenaResponseDto escenaResponseDtoItem:escenaResponseDtoList) {
            escenaResponseDtoItem.setHotSpotResponseDtoList(iHotSpotHandler.getAllHotSpotByEscenaId(escenaResponseDtoItem.getId()));
        }
        return escenaResponseDtoList;

    }


}
