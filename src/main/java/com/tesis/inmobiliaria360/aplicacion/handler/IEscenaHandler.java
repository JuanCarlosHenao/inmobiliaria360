package com.tesis.inmobiliaria360.aplicacion.handler;

import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.dominio.model.Escena;

import java.util.List;

public interface IEscenaHandler {


    void saveEscena(EscenaRequestDto escenaRequestDto);  //Esto podría ser saveEscenaDto
    List<EscenaResponseDto> getAllEscenas();

    EscenaResponseDto getEscenaById(Long id);

    List<EscenaResponseDto> getAllEscenasByInmuebleId(Long id);

    void updateEscena (Long id, EscenaRequestDto escenaRequestDto);



}
