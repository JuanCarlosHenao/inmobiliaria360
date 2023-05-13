package com.tesis.inmobiliaria360.aplicacion.handler;

import com.tesis.inmobiliaria360.aplicacion.dto.request.InmuebleRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.InmuebleResponseDto;

import java.util.List;

public interface IInmuebleHandler {
    String saveInmueble(InmuebleRequestDto inmuebleDtoRequest);
    String deleteInmueble(InmuebleRequestDto inmuebleDtoRequest);
    String updateInmueble(Long id,InmuebleRequestDto inmuebleDtoRequest);
    InmuebleResponseDto getInmuebleById(Long id);

    List<InmuebleResponseDto> getAllInmuebles();

}
