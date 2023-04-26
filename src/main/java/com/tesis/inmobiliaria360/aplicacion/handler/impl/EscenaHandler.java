package com.tesis.inmobiliaria360.aplicacion.handler.impl;

import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.aplicacion.handler.IEscenaHandler;
import com.tesis.inmobiliaria360.aplicacion.mapper.request.IEscenaRequestMapper;
import com.tesis.inmobiliaria360.aplicacion.mapper.response.IEscenaResponseMapper;
import com.tesis.inmobiliaria360.dominio.api.IEscenaServicePort;
import com.tesis.inmobiliaria360.dominio.model.Escena;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


//@RequiredArgsConstructor // porque requiere usar todas las interfaces
//@Service // porque manipula y tiene lógica para los datos
//@Transactional  // para la parte transaccional de agregar las diferentes escenas
//public class EscenaHandler implements IEscenaHandler {
////    private final IEscenaServicePort escenaServicePort;
////    private final IEscenaRequestMapper escenaRequestMapper;
////    private final IEscenaResponseMapper escenaResponseMapper;
////
////
////    @Override
////    public void saveEscena(EscenaRequestDto escenaRequestDto) {
////        Escena escena=escenaRequestMapper.toEscena(escenaRequestDto);
////        escenaServicePort.saveEscena(escena);
////    }
////
////    @Override
////    public List<EscenaResponseDto> getAllEscenas() {
////        return escenaResponseMapper.toEscenaResponseDtoList(escenaServicePort.getAllEscenas()) ;
////    }
//
//
//}
